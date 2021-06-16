package Testcases.Railway;

import Common.Constant.Constant;
import Common.Utilities.Utilities;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookTicketTest {
    @BeforeTest
    public void beforeMethod(){
        System.out.println("Pre-Condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() +
                "/src/test/java/Executables/chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-Condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01(){
        LoginTest login = new LoginTest();
        login.TC01();
        System.out.println("TC01 - User can book ticket with valid info");
        HomePage homePage = new HomePage();
        homePage.open();

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        String actualMsg = bookTicketPage.bookTicket("6/20/2021", "Sài Gòn", "Đà Nẵng", "Hard seat", "1").getBookTicketSuccessfulMsg();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket successful message is not displayed as expected");

    }
}
