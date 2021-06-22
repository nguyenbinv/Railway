package Testcases.Railway.LoginTest;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.Railway.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase03 extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test(description = "TC03 - User cannot log into Railway with invalid password")
    public void TC03() {
        logger = extent.startTest("TC03 - User cannot log into Railway with invalid password");

        logger.log(LogStatus.PASS,"1. Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.PASS,"2. Click on \"Login\" tab");
        loginPage = homePage.gotoLoginPage();

        logger.log(LogStatus.PASS,"3. Enter valid Email and invalid Password");
        logger.log(LogStatus.PASS,"4. Click on \"Login\" button");
        loginPage.login(Constant.USERNAME, "");

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Login error message is not displayed as expected");
    }
}
