package Testcases.Railway.LoginTest;

import PageObjects.Railway.*;
import Testcases.Railway.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase04 extends BaseTest {
    private HomePage homePage = new HomePage();
    private BookTicketPage bookTicketPage;

    @Test(description = "TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        logger = extent.startTest("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");

        logger.log(LogStatus.PASS,"1. Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.PASS,"2. Click on \"Book ticket\" tab");
        bookTicketPage = homePage.gotoBookTicketPage();

        String actualTitle = bookTicketPage.getPageTitle();
        String expectedTitle = "Safe Railway - Login";

        Assert.assertEquals(actualTitle, expectedTitle, "Login page is not displayed instead of Book ticket page");
    }
}
