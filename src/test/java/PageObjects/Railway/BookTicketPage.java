package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    private final By lblDepartStation = By.xpath("//td[count(//tr/th[text()='Depart Station']/preceding-sibling::th)+1]");
    private final By lblArriveStation = By.xpath("//td[count(//tr/th[text()='Arrive Station']/preceding-sibling::th)+1]");
    private final By lblSeatType = By.xpath("//td[count(//tr/th[text()='Seat Type']/preceding-sibling::th)+1]");
    private final By lblDepartDate = By.xpath("//td[count(//tr/th[text()='Depart Date']/preceding-sibling::th)+1]");
    private final By lblTicketAmount = By.xpath("//td[count(//tr/th[text()='Amount']/preceding-sibling::th)+1]");

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

    protected WebElement getLblDepartStation() {
        return Constant.WEBDRIVER.findElement(lblDepartStation);
    }

    protected WebElement getLblArriveStation() {
        return Constant.WEBDRIVER.findElement(lblArriveStation);
    }

    protected WebElement getLblSeatType() {
        return Constant.WEBDRIVER.findElement(lblSeatType);
    }

    protected WebElement getLblDepartDate() {
        return Constant.WEBDRIVER.findElement(lblDepartDate);
    }

    protected WebElement getLblTicketAmount() {
        return Constant.WEBDRIVER.findElement(lblTicketAmount);
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
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollBy(0,350)", "");
        getBtnBookTicket().click();

        return this;
    }

    public String getBookTicketSuccessfulMsg() {
        return this.getLblBookSuccessful().getText();
    }

    public String getDepartDateInfo() {
        return this.getLblDepartDate().getText();
    }

    public String getDepartStationInfo() {
        return this.getLblDepartStation().getText();
    }

    public String getArriveStationInfo() {
        return this.getLblArriveStation().getText();
    }

    public String getSeatTypeInfo() {
        return this.getLblSeatType().getText();
    }

    public String getTicketAmountInfo() {
        return this.getLblTicketAmount().getText();
    }
}
