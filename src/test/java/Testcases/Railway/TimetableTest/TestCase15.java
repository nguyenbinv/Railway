package Testcases.Railway.TimetableTest;

import Common.Constant.Constant;
import Common.Utilities.CheckBookTicketStation;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TimetablePage;
import Testcases.Railway.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase15 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage;
    TimetablePage timetablePage;
    BookTicketPage bookTicketPage;

    @Test(description = "TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15() {
        logger = extent.startTest("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");

        logger.log(LogStatus.PASS,"1. Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.PASS,"2. Login with a valid account");
        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.NEW_PASSWORD);

        logger.log(LogStatus.PASS,"3. Click on \"Timetable\" tab");
        timetablePage = homePage.gotoTimetablePage();

        logger.log(LogStatus.PASS,"4. Click on \"book ticket\" link of the route from \"Huế\" to \"Sài Gòn\"");
        bookTicketPage = timetablePage.bookTicket("Huế", "Sài Gòn", "7:30", "21:00");

        boolean checkStationValue = CheckBookTicketStation.checkBookTicketStation(bookTicketPage, "Huế", "Sài Gòn");
        Assert.assertTrue(checkStationValue);
    }
}
