package Testcases.Railway.RegisterTest;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11 {
    HomePage homePage = new HomePage();
    RegisterPage registerPage;
    
    @Test
    public void TC11() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        registerPage = homePage.gotoRegisterPage();

        System.out.println("3. Enter valid email address and leave other fields empty");
        System.out.println("4. Click on \"Register\" button");
        registerPage.register("nguyenvanhuy00@gmail.com", "", "abcd4321", "");

        String actualErrorMsg = registerPage.getErrorMessage();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "A register message is not displayed as expected");

        String actualPasswordMsg = registerPage.getPasswordMessage();
        String expectedPasswordMsg = "Invalid password length";
        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "A password message is not displayed as expected");

        String actualPIDMsg = registerPage.getPIDMessage();
        String expectedPIDMsg = "Invalid ID length";
        Assert.assertEquals(actualPIDMsg, expectedPIDMsg, "A PID message is not displayed as expected");
    }
}
