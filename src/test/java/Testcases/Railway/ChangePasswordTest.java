package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage;

    @Test
    public void TC09() {
        System.out.println("TC09 - User can change password");

        homePage.open();

        loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        changePasswordPage = homePage.gotoChangePasswordPage();

        changePasswordPage.changePassword(Constant.PASSWORD, "abcd4321", "abcd4321");

        String actualMsg = changePasswordPage.getChangePasswordMessage();
        String expectedMsg = "Your password has been updated";

        Assert.assertEquals(actualMsg, expectedMsg, "A change password message is not displayed as expected");
    }
}
