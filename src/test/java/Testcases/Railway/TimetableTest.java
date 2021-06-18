package Testcases.Railway;

import Common.Constant.Constant;
import Common.Utilities.CheckBookTicketStation;
import Common.Utilities.CheckTicketInfo;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TimetablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimetableTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage;
    TimetablePage timetablePage;
    BookTicketPage bookTicketPage;

    @Test
    public void TC15() {
        System.out.println("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");

        homePage.open();

        loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        timetablePage = homePage.gotoTimetablePage();

        bookTicketPage = timetablePage.bookTicket("Huế", "Sài Gòn", "7:30", "21:00");

        boolean checkStationValue = CheckBookTicketStation.checkBookTicketStation(bookTicketPage, "Huế", "Sài Gòn");
        Assert.assertTrue(checkStationValue);
    }
}
