package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    //Locator
    private final By drbDepartDate = By.xpath("//select[@name='Date']");
    private final By drbDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By drbArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By drbSeatType = By.xpath("//select[@name='SeatType']");
    private final By drbTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By btnBookTicket = By.xpath("//input[@type='submit']");
    private final By lblBookSuccessful = By.xpath("//h1");

    //Elements
    protected WebElement getDrbDepartDate() {
        return Constant.WEBDRIVER.findElement(drbDepartDate);
    }

    protected WebElement getDrbDepartFrom() {
        return Constant.WEBDRIVER.findElement(drbDepartFrom);
    }

    protected WebElement getDrbArriveAt() {
        return Constant.WEBDRIVER.findElement(drbArriveAt);
    }

    protected WebElement getDrbSeatType() {
        return Constant.WEBDRIVER.findElement(drbSeatType);
    }

    protected WebElement getDrbTicketAmount() {
        return Constant.WEBDRIVER.findElement(drbTicketAmount);
    }

    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    protected WebElement getLblBookSuccessful() {
        return Constant.WEBDRIVER.findElement(lblBookSuccessful);
    }

    //Methods
    public BookTicketPage bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        //Submit book ticket credentials
        Select selectDepartDate = new Select(getDrbDepartDate());
        selectDepartDate.selectByVisibleText(departDate);
        Select selectDepartFrom = new Select(getDrbDepartFrom());
        selectDepartFrom.selectByVisibleText(departFrom);
        Select selectArriveAt = new Select(getDrbArriveAt());
        selectArriveAt.selectByVisibleText(arriveAt);
        Select selectSeatType = new Select(getDrbSeatType());
        selectSeatType.selectByVisibleText(seatType);
        Select selectTicketAmount = new Select(getDrbTicketAmount());
        selectTicketAmount.selectByVisibleText(ticketAmount);
        getBtnBookTicket().click();

        return this;
    }

    public String getBookTicketSuccessfulMsg() {
        return this.getLblBookSuccessful().getText();
    }
}
