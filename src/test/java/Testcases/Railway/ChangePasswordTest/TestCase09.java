package Testcases.Railway.ChangePasswordTest;

import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import Testcases.Railway.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase09 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage;

    @Test(description = "TC09 - User can change password")
    public void TC09() {
        logger = extent.startTest("TC09 - User can change password");

        logger.log(LogStatus.PASS,"1. Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.PASS,"2. Login with valid account");
        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        logger.log(LogStatus.PASS,"3. Click on \"Change Password\" tab");
        changePasswordPage = homePage.gotoChangePasswordPage();

        logger.log(LogStatus.PASS,"4. Enter valid value into all fields");
        logger.log(LogStatus.PASS,"5. Click on \"Change Password\" button");
        changePasswordPage.changePassword(Constant.PASSWORD, "abcd4321", "abcd4321");

        String actualMsg = changePasswordPage.getChangePasswordMessage();
        String expectedMsg = "Your password has been updated!";

        Assert.assertEquals(actualMsg, expectedMsg, "A change password message is not displayed as expected");
    }
}
