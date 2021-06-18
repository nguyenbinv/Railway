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

        homePage.open();

        loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        bookTicketPage = homePage.gotoBookTicketPage();

        bookTicketPage.bookTicket("6/23/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");

        String actualBookTicketMsg = bookTicketPage.getBookTicketSuccessfulMsg();
        String expectedBookTicketMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualBookTicketMsg, expectedBookTicketMsg, "A book ticket message is not displayed as expected");

        boolean checkActualTicketInfo = CheckBookTicketInfo.checkTicketInfo(bookTicketPage, "6/23/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        Assert.assertTrue(checkActualTicketInfo, "Ticket info is not display as booked");
    }
}
