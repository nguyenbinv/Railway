package Testcases.Railway.RegisterTest;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import Testcases.Railway.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11 extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage;

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        logger = extent.startTest("TC11 - User can't create account while password and PID fields are empty");

        logger.log(LogStatus.PASS,"1. Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.PASS,"2. Click on \"Register\" tab");
        registerPage = homePage.gotoRegisterPage();

        logger.log(LogStatus.PASS,"3. Enter valid email address and leave other fields empty");
        logger.log(LogStatus.PASS,"4. Click on \"Register\" button");
        registerPage.register("nguyenvanhuy00@gmail.com", "", "abcd4321", "");

        String actualErrorMsg = registerPage.getErrorMessage();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "A register message is not displayed as expected");

        String actualPasswordMsg = registerPage.getPasswordMessage();
        String expectedPasswordMsg = "Invalid password length";
        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "A password message is not displayed as expected");

        String actualPIDMsg = registerPage.getPIDMessage();
        String expectedPIDMsg = "Invalid ID length";
        Assert.assertEquals(actualPIDMsg, expectedPIDMsg, "A PID message is not displayed as expected");
    }
}
