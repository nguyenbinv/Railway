package Testcases.Railway;

import Common.Constant.Constant;
import Common.Utilities.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");

        homePage.open();

        homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02(){
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");

        homePage.open();

        homePage.gotoLoginPage();

        String actualMsg = loginPage.login("", Constant.PASSWORD).
    }

}
