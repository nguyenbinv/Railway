package Testcases.Railway.LoginTest;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.Railway.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 extends BaseTest{
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        logger = extent.startTest("TC01 - User can log into Railway with valid username and password");
        logger.log(LogStatus.PASS, "1. Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.PASS,"2. Click on \"Login\" tab");
        loginPage = homePage.gotoLoginPage();

        logger.log(LogStatus.PASS,"3. Enter valid Email and Password");
        logger.log(LogStatus.PASS,"4. Click on \"Login\" button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
