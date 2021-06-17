package Testcases.Railway;

import Common.Constant.Constant;
import Common.Utilities.Utilities;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
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

        bookTicketPage.bookTicket("6/22/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");

        String actualBookTicketMsg = bookTicketPage.getBookTicketSuccessfulMsg();
        String expectedBookTicketMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualBookTicketMsg, expectedBookTicketMsg, "A book ticket message is not displayed as expected");

        String actualDepartStationInfo = bookTicketPage.getDepartStationInfo();
        String expectedDepartStationInfo = "Sài Gòn";
        Assert.assertEquals(actualDepartStationInfo, expectedDepartStationInfo);

        String actualDepartArriveInfo = bookTicketPage.getArriveStationInfo();
        String expectedDepartArriveInfo = "Nha Trang";
        Assert.assertEquals(actualDepartArriveInfo, expectedDepartArriveInfo);

        String actualDepartDateInfo = bookTicketPage.getDepartDateInfo();
        String expectedDepartDateInfo = "6/22/2021";
        Assert.assertEquals(actualDepartDateInfo, expectedDepartDateInfo);

        String actualSeatTypeInfo = bookTicketPage.getSeatTypeInfo();
        String expectedSeatTypeInfo = "Soft bed with air conditioner";
        Assert.assertEquals(actualSeatTypeInfo, expectedSeatTypeInfo);

        String actualTicketAmountInfo = bookTicketPage.getTicketAmountInfo();
        String expectedTicketAmountInfo = "1";
        Assert.assertEquals(actualTicketAmountInfo, expectedTicketAmountInfo);
    }
}
