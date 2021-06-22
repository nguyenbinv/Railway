package Testcases.Railway.RegisterTest;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import Testcases.Railway.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage;

    @Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {
        logger = extent.startTest("TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"");

        logger.log(LogStatus.PASS,"1. Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.PASS,"2. Click on \"Register\" tab");
        registerPage = homePage.gotoRegisterPage();

        logger.log(LogStatus.PASS,"3. Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\"");
        logger.log(LogStatus.PASS,"4. Click on \"Register\" button");
        registerPage.register("nguyenvanhuy00@gmail.com", "abcd1234", "abcd4321", "123456780");

        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "A register message is not displayed as expected");
    }
}
