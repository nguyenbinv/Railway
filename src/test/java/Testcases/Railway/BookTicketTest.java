package Testcases.Railway;

import Common.Constant.Constant;
import Common.Utilities.CheckBookTicketInfo;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage;
    BookTicketPage bookTicketPage;

    @Test
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account");
        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.NEW_PASSWORD);

        System.out.println("3. Click on \"Book ticket\" tab");
        bookTicketPage = homePage.gotoBookTicketPage();

        System.out.println("4. Select valid value from lists");
        System.out.println("5. Click on \"Book ticket\" button");
        bookTicketPage.bookTicket("6/24/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");

        String actualBookTicketMsg = this.bookTicketPage.getBookTicketSuccessfulMsg();
        String expectedBookTicketMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualBookTicketMsg, expectedBookTicketMsg, "A book ticket message is not displayed as expected");

        boolean checkActualTicketInfo = CheckBookTicketInfo.checkTicketInfo(this.bookTicketPage, "6/24/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        Assert.assertTrue(checkActualTicketInfo, "Ticket info is not display as booked");
    }
}
