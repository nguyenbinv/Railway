package Testcases.Railway.MyTicketTest;

import Common.Constant.Constant;
import Common.Utilities.CheckMyTicketInfo;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase16 {
    HomePage homePage = new HomePage();
    LoginPage loginPage;
    MyTicketPage myTicketPage;
    BookTicketPage bookTicketPage;

    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account");
        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.NEW_PASSWORD);

        System.out.println("3. Book a ticket");
        bookTicketPage = homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket("6/28/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");

        System.out.println("4. Click on \"My ticket\" tab");
        myTicketPage = homePage.gotoMyTicketPage();

        System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.cancelTicket("6/28/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");

        boolean checkTicketIsCanceled = !CheckMyTicketInfo.checkMyTicketInfo(myTicketPage, "6/28/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        Assert.assertTrue(checkTicketIsCanceled);
    }
}
