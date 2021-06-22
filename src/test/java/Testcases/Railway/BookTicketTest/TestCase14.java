package Testcases.Railway.BookTicketTest;

import Common.Constant.Constant;
import Common.Utilities.CheckBookTicketInfo;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import Testcases.Railway.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase14 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage;
    BookTicketPage bookTicketPage;

    //    @Test(dataProvider="BookTicketDataSet",dataProviderClass= BookTicketDataSet.class)
//    public void TC14(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14() {
        logger = extent.startTest("TC14 - User can book 1 ticket at a time");

        logger.log(LogStatus.PASS, "1. Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.PASS, "2. Login with a valid account");
        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.NEW_PASSWORD);

        logger.log(LogStatus.PASS, "3. Click on \"Book ticket\" tab");
        bookTicketPage = homePage.gotoBookTicketPage();

        logger.log(LogStatus.PASS, "4. Select valid value from lists");
        logger.log(LogStatus.PASS, "5. Click on \"Book ticket\" button");
//        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);
        bookTicketPage.bookTicket("6/28/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");

        String actualBookTicketMsg = this.bookTicketPage.getBookTicketSuccessfulMsg();
        String expectedBookTicketMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualBookTicketMsg, expectedBookTicketMsg, "A book ticket message is not displayed as expected");

        boolean checkActualTicketInfo = CheckBookTicketInfo.checkTicketInfo(bookTicketPage, "6/28/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        Assert.assertTrue(checkActualTicketInfo, "Ticket info is not display as booked");
    }
}
