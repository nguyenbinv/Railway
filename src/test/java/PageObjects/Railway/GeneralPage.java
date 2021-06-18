package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locator
    private final By tabHome = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Home']");
    private final By tabFAQ = By.xpath("//div[@id='menu']/ul/li/a/span[text()='FAQ']");
    private final By tabContact = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Contact']");
    private final By tabTimetable = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Timetable']");
    private final By tabTicketPrice = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Ticket price']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Book ticket']");
    private final By tabRegister = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Register']");
    private final By tabLogin = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Login']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']/ul/li/a/span[text()='My ticket']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Change password']");
    private final By tabLogout = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Log out']");
    private final By lblWelcomeMessage = By.xpath("//div[@id='banner']/div/strong");

    //Elements
    protected WebElement getTabHome() {
        return Constant.WEBDRIVER.findElement(tabHome);
    }

    protected WebElement getTabFAQ() {
        return Constant.WEBDRIVER.findElement(tabFAQ);
    }

    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    protected WebElement getTabTimetable() {
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    protected WebElement getTabTicketPrice() {
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    //Methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public RegisterPage gotoRegisterPage() {
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public BookTicketPage gotoBookTicketPage() {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }

    public String getPageTitle() {
        return Constant.WEBDRIVER.getTitle();
    }

    public MyTicketPage gotoMyTicketPage() {
        this.getTabMyTicket().click();
        return new MyTicketPage();
    }

    public ChangePasswordPage gotoChangePasswordPage() {
        this.getTabChangePassword().click();
        return new ChangePasswordPage();
    }

    public void gotoLogout() {
        this.getTabLogout().click();
    }
}
