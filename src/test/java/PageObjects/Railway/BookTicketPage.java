package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage {
    //Locator
    private final By drbDepartDate = By.xpath("//select[@name='Date']");
    private final By drbDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By drbArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By drbSeatType = By.xpath("//select[@name='SeatType']");
    private final By drbTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By btnBookTicket = By.xpath("//input[@type='submit']");

    //Elements
    protected WebElement getDrbDepartDate(){
        return Constant.WEBDRIVER.findElement(drbDepartDate);
    }

    protected WebElement getDrbDepartFrom(){
        return Constant.WEBDRIVER.findElement(drbDepartFrom);
    }

    protected WebElement getDrbArriveAt(){
        return Constant.WEBDRIVER.findElement(drbArriveAt);
    }

    protected WebElement getDrbSeatType(){
        return Constant.WEBDRIVER.findElement(drbSeatType);
    }

    protected WebElement getDrbTicketAmount(){
        return Constant.WEBDRIVER.findElement(drbTicketAmount);
    }

    protected WebElement getBtnBookTicket(){
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }
}
