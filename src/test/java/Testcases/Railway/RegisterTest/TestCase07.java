package Testcases.Railway.RegisterTest;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import Testcases.Railway.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TestCase07 extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage;

    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        logger = extent.startTest("TC07 - User can create new account");

        logger.log(LogStatus.PASS,"1. Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.PASS,"2. Click on \"Register\" tab");
        registerPage = homePage.gotoRegisterPage();

        Random generator = new Random();

        logger.log(LogStatus.PASS,"3. Enter valid information into all fields");
        logger.log(LogStatus.PASS,"4. Click on \"Register\" button");
        registerPage.register("nguyenvanhuy" + generator.nextInt(9999) + "@gmail.com", "abcd1234", "abcd1234", "123456780");

        String actualMsg = registerPage.getRegisterMessage();
        String expectedMsg = "You're here";

        Assert.assertEquals(actualMsg, expectedMsg, "A register message is not displayed as expected");
    }
}
