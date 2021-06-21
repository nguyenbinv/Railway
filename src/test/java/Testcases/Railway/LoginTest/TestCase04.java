package Testcases.Railway.LoginTest;

import PageObjects.Railway.*;
import Testcases.Railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase04 extends BaseTest {
    private HomePage homePage = new HomePage();
    private BookTicketPage bookTicketPage;

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
}
