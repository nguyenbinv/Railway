package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    //Locator
    private final By linkLogin = By.xpath("//div[@id='content']/p/a[text()='login']");
    private final By linkConfirmEmail = By.xpath("//div[@id='content']/p/a[text()='here']");
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By txtPID = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//p/input[@type='submit']");
    private final By lblErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblSuccessfulMsg = By.xpath("//div[@id='content']/p");

    //Elements
    protected WebElement linkLogin() {
        return Constant.WEBDRIVER.findElement(linkLogin);
    }

    protected WebElement linkConfirmEmail() {
        return Constant.WEBDRIVER.findElement(linkConfirmEmail);
    }

    protected WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    protected WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    protected WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(txtPID);
    }

    protected WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    protected WebElement getLblErrorMsg(){
        return Constant.WEBDRIVER.findElement(lblErrorMsg);
    }

    protected WebElement getLblSuccessfulMsg(){
        return Constant.WEBDRIVER.findElement(lblSuccessfulMsg);
    }

    //Methods
    public RegisterPage register(String email, String password, String confirmPassword, String PID){
        //Submit register credentials
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPID().sendKeys(PID);
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollBy(0,350)", "");
        this.getBtnRegister().click();

        //Land on register page
        return this;
    }

    public String getRegisterSuccessfulMessage(){
        return this.getLblSuccessfulMsg().getText();
    }

}
