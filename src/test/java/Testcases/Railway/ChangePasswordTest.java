package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage;

    @Test
    public void TC09() {
        System.out.println("TC09 - User can change password");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with valid account");
        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on \"Change Password\" tab");
        changePasswordPage = homePage.gotoChangePasswordPage();

        System.out.println("4. Enter valid value into all fields");
        System.out.println("5. Click on \"Change Password\" button");
        changePasswordPage.changePassword(Constant.PASSWORD, "abcd4321", "abcd4321");

        String actualMsg = changePasswordPage.getChangePasswordMessage();
        String expectedMsg = "Your password has been updated";

        Assert.assertEquals(actualMsg, expectedMsg, "A change password message is not displayed as expected");
    }
}
