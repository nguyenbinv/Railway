package Testcases.Railway;

import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class RegisterTest extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage;

    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");

        homePage.open();

        registerPage = homePage.gotoRegisterPage();

        Random generator = new Random();

        registerPage.register("nguyenvanhuy" + generator.nextInt(9999) + "@gmail.com", "abcd1234", "abcd1234", "123456780");

        String actualMsg = registerPage.getRegisterMessage();
        String expectedMsg = "Thank you for registering your account";

        Assert.assertEquals(actualMsg, expectedMsg, "A register message is not displayed as expected");
    }

    @Test
    public void TC10() {
        System.out.println("TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"");

        homePage.open();

        registerPage = homePage.gotoRegisterPage();

        registerPage.register("nguyenvanhuy00@gmail.com", "abcd1234", "abcd4321", "123456780");

        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "A register message is not displayed as expected");
    }

    @Test
    public void TC11() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");

        homePage.open();

        registerPage = homePage.gotoRegisterPage();

        registerPage.register("nguyenvanhuy00@gmail.com", "", "abcd4321", "");

        String actualErrorMsg = registerPage.getErrorMessage();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "A register message is not displayed as expected");

        String actualPasswordMsg = registerPage.getPasswordMessage();
        String expectedPasswordMsg = "Invalid password length.";
        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "A password message is not displayed as expected");

        String actualPIDMsg = registerPage.getPIDMessage();
        String expectedPIDMsg = "Invalid ID length.";
        Assert.assertEquals(actualPIDMsg, expectedPIDMsg, "A PID message is not displayed as expected");
    }

}
