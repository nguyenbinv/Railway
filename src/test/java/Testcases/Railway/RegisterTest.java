package Testcases.Railway;

import Common.Constant.Constant;
import Common.Utilities.Utilities;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest {
    @BeforeTest
    public void beforeMethod(){
        System.out.println("Pre-Condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() +
                "/src/test/java/Executables/chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-Condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC02(){
        System.out.println("TC01 - User can register Railway with valid email and password");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();

        String actualMsg = registerPage.register("nguyenvanhuy5@gmail.com", "abcd1234", "abcd1234", "123456789").getRegisterSuccessfulMessage();
        String expectedMsg = "You're here";

        Assert.assertEquals(actualMsg, expectedMsg, "Successful message is not displayed as expected");
    }
}
