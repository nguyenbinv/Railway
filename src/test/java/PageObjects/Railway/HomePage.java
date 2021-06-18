package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    //Locator
    private final By linkCreateAnAccount = By.xpath("//div[@id='content']/div/a");

    //Elements
    protected WebElement getLinkCreateAnAccount() {
        return Constant.WEBDRIVER.findElement(linkCreateAnAccount);
    }

    //Methods
    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
