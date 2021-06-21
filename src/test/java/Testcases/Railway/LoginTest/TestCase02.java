package Testcases.Railway.LoginTest;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.Railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

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
}
