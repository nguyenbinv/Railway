package Testcases.Railway.RegisterTest;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TestCase07 {
    HomePage homePage = new HomePage();
    RegisterPage registerPage;

    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        registerPage = homePage.gotoRegisterPage();

        Random generator = new Random();

        System.out.println("3. Enter valid information into all fields");
        System.out.println("4. Click on \"Register\" button");
        registerPage.register("nguyenvanhuy" + generator.nextInt(9999) + "@gmail.com", "abcd1234", "abcd1234", "123456780");

        String actualMsg = registerPage.getRegisterMessage();
        String expectedMsg = "You're here";

        Assert.assertEquals(actualMsg, expectedMsg, "A register message is not displayed as expected");
    }
}
