package Testcases.Railway.LoginTest;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.Railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage;

    @Test()
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
}
