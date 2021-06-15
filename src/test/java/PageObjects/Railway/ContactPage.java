package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {
    //Locator
    private final By linkEmail = By.xpath("//div[@class='contact']/p/a");

    //Elements
    protected WebElement getLinkEmail() {
        return Constant.WEBDRIVER.findElement(linkEmail);
    }
}
