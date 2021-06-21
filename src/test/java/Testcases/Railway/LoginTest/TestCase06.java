package Testcases.Railway.LoginTest;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.Railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase06 extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private MyTicketPage myTicketPage;
    private ChangePasswordPage changePasswordPage;

    @Test
    public void TC06() {
        System.out.println("TC06 - Additional pages display once user logged in");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        loginPage = homePage.gotoLoginPage();

        System.out.println("3. Login with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        myTicketPage = loginPage.gotoMyTicketPage();
        String actualTitle = myTicketPage.getPageTitle();
        String expectedTitle = "Safe Railway - My Ticket";
        Assert.assertEquals(actualTitle, expectedTitle, "My ticket page is not displayed as expected");

        changePasswordPage = loginPage.gotoChangePasswordPage();
        String actualTitle1 = changePasswordPage.getPageTitle();
        String expectedTitle1 = "Safe Railway - Change Password";
        Assert.assertEquals(actualTitle1, expectedTitle1, "Change password page is not displayed as expected");

        loginPage.gotoLogout();
        String actualTitle2 = loginPage.getPageTitle();
        String expectedTitle2 = "Safe Railway - Selenium Automation";
        Assert.assertEquals(actualTitle2, expectedTitle2, "Logout tab is not displayed as expected");
    }
}
