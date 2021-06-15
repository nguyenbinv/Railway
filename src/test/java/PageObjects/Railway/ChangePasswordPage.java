package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    //Locator
    private final By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By btnChangePassword = By.xpath("//input[@type='submit']");

    //Elements
    protected WebElement getTxtCurrentPassword(){
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }

    protected WebElement getTxtNewPassword(){
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }

    protected WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    protected WebElement getBtnChangePassword(){
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }
}
