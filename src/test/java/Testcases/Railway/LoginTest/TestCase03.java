package Testcases.Railway.LoginTest;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.Railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase03 extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

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
}
