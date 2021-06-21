package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;
    private BookTicketPage bookTicketPage;
    private MyTicketPage myTicketPage;
    private ChangePasswordPage changePasswordPage;
    private RegisterPage registerPage;

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        loginPage = homePage.gotoLoginPage();

        System.out.println("3. Enter valid Email and Password");
        System.out.println("4. Click on \"Login\" button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        loginPage = homePage.gotoLoginPage();

        System.out.println("3. User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox");
        System.out.println("4. Click on \"Login\" button");
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Login error message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        loginPage = homePage.gotoLoginPage();

        System.out.println("3. Enter valid Email and invalid Password");
        System.out.println("4. Click on \"Login\" button");
        loginPage.login(Constant.USERNAME, "");

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Login error message is not displayed as expected");
    }

    @Test
    public void TC04() {
        System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Book ticket\" tab");
        bookTicketPage = homePage.gotoBookTicketPage();

        String actualTitle = bookTicketPage.getPageTitle();
        String expectedTitle = "Safe Railway - Login";

        Assert.assertEquals(actualTitle, expectedTitle, "Login page is not displayed instead of Book ticket page");
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        LoginPage loginPage = homePage.gotoLoginPage();

        System.out.println("3. Enter valid information into \"Username\" textbox except \"Password\" textbox");
        System.out.println("4. Click on \"Login\" button");
        System.out.println("5. Repeat step 3 three more times.");
        for (int i = 0; i < 4; i++) {
            JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
            jse.executeScript("scroll(0, 9000)");
            loginPage.login(Constant.USERNAME, "abcd4321");
        }

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualMsg, expectedMsg, "Login error message is not displayed as expected");
    }

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
