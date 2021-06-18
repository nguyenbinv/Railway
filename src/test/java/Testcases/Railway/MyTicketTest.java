package Testcases.Railway;

import Common.Constant.Constant;
import Common.Utilities.CheckMyTicketInfo;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage;
    MyTicketPage myTicketPage;

    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");

        homePage.open();

        loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        myTicketPage = homePage.gotoMyTicketPage();

        myTicketPage.cancelTicket("6/23/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");

        boolean checkTicketIsCanceled = !CheckMyTicketInfo.checkMyTicketInfo(myTicketPage, "6/23/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        Assert.assertTrue(checkTicketIsCanceled);
    }
}
