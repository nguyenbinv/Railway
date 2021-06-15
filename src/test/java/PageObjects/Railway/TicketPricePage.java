package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    //Elements
    protected WebElement getCheckPrice(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//tbody/tr/td/li[text()='" + departStation + " to " +
                arriveStation + "']/parent::td/parent::tr/td/a"));
    }
}
