package Testcases.Railway.RegisterTest;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 {
    HomePage homePage = new HomePage();
    RegisterPage registerPage;

    @Test
    public void TC10() {
        System.out.println("TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        registerPage = homePage.gotoRegisterPage();

        System.out.println("3. Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\"");
        System.out.println("4. Click on \"Register\" button");
        registerPage.register("nguyenvanhuy00@gmail.com", "abcd1234", "abcd4321", "123456780");

        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "A register message is not displayed as expected");
    }
}
