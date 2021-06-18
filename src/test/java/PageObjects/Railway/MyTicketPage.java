package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicketPage extends GeneralPage {
    //Locator
    private final By drbDepartStationFilter = By.xpath("//select[@name='FilterDpStation']");
    private final By drbArriverStationFilter = By.xpath("//select[@name='FilterArStation']");
    private final By txtDepartDateFilter = By.xpath("//input[@name='FilterDpDate']");
    private final By drbStatus = By.xpath("//select[@name='FilterStatus']");
    private final By btnApplyFilter = By.xpath("//input[@type='submit']");
    private final By lblDepartStationInfo = By.xpath("//table[@class='MyTable']/tbody/tr/td[count(//tr/th[text()='Depart Station']/preceding-sibling::th)+1]");
    private final By lblArriveStationInfo = By.xpath("//table[@class='MyTable']/tbody/tr/td[count(//tr/th[text()='Arrive Station']/preceding-sibling::th)+1]");
    private final By lblSeatTypeInfo = By.xpath("//table[@class='MyTable']/tbody/tr/td[count(//tr/th[text()='Seat Type Station']/preceding-sibling::th)+1]");
    private final By lblDepartDateInfo = By.xpath("//table[@class='MyTable']/tbody/tr/td[count(//tr/th[text()='Depart Date']/preceding-sibling::th)+1]");
    private final By lblAmountInfo = By.xpath("//table[@class='MyTable']/tbody/tr/td[count(//tr/th[text()='Amount']/preceding-sibling::th)+1]");
    private final By tableContent = By.xpath("//table[@class='MyTable']");

    //Elements
    protected WebElement getDrbDepartStationFilter() {
        return Constant.WEBDRIVER.findElement(drbDepartStationFilter);
    }

    protected WebElement getDrbArriverStationFilter() {
        return Constant.WEBDRIVER.findElement(drbArriverStationFilter);
    }

    protected WebElement getTxtDepartDateFilter() {
        return Constant.WEBDRIVER.findElement(txtDepartDateFilter);
    }

    protected WebElement getDrbStatus() {
        return Constant.WEBDRIVER.findElement(drbStatus);
    }

    protected WebElement getBtnApplyFilter() {
        return Constant.WEBDRIVER.findElement(btnApplyFilter);
    }

    protected WebElement getBtnCancel(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']/tbody/tr/td[" +
                "text()='" + departStation + "']/following-sibling::td[" +
                "text()='" + arriveStation + "']/following-sibling::td[" +
                "text()='" + seatType + "']/following-sibling::td[" +
                "text()='" + departDate + "']/following-sibling::td[" +
                "text()='" + ticketAmount + "']/following-sibling::td/input"));
    }

    protected WebElement getLblDepartStationInfo() {
        return Constant.WEBDRIVER.findElement(lblDepartStationInfo);
    }

    protected WebElement getLblArriveStationInfo() {
        return Constant.WEBDRIVER.findElement(lblArriveStationInfo);
    }

    protected WebElement getLblSeatTypeInfo() {
        return Constant.WEBDRIVER.findElement(lblSeatTypeInfo);
    }

    protected WebElement getLblDepartDateInfo() {
        return Constant.WEBDRIVER.findElement(lblDepartDateInfo);
    }

    protected WebElement getLblAmountInfo() {
        return Constant.WEBDRIVER.findElement(lblAmountInfo);
    }

    protected List<WebElement> getTableContent() {
        return Constant.WEBDRIVER.findElements(tableContent);
    }

    //Methods
    public boolean isTableContentExist() {
        return !getTableContent().isEmpty();
    }

    public void cancelTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        this.getBtnCancel(departDate, departStation, arriveStation, seatType, ticketAmount).click();
        Constant.WEBDRIVER.switchTo().alert().accept();

    }

    public String getDepartStation() {
        return getLblDepartStationInfo().getText();
    }

    public String getArriveStation() {
        return getLblArriveStationInfo().getText();
    }

    public String getSeatType() {
        return getLblSeatTypeInfo().getText();
    }

    public String getDepartDate() {
        return getLblDepartDateInfo().getText();
    }

    public String getAmount() {
        return getLblAmountInfo().getText();
    }

}
