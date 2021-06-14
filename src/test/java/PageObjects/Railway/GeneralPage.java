package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locator
    private final By tabLogin = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Login']");
    private final By tabLogout = By.xpath("//div[@id='menu']/ul/li/a/span[text()='Log out']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']");

    //Elements
    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getlblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    //Methods
    public String getWelcomeMessage(){
        return this.getlblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

}
