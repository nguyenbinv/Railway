package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    //Locator
    private final By drbDepartStationFilter = By.xpath("//select[@name='FilterDpStation']");
    private final By drbArriverStationFilter = By.xpath("//select[@name='FilterArStation']");
    private final By txtDepartDateFilter = By.xpath("//input[@name='FilterDpDate']");
    private final By drbStatus = By.xpath("//select[@name='FilterStatus']");
    private final By btnApplyFilter = By.xpath("//input[@type='submit']");

    //Elements
    protected WebElement getDrbDepartStationFilter(){
        return Constant.WEBDRIVER.findElement(drbDepartStationFilter);
    }

    protected WebElement getDrbArriverStationFilter(){
        return Constant.WEBDRIVER.findElement(drbArriverStationFilter);
    }

    protected WebElement getTxtDepartDateFilter(){
        return Constant.WEBDRIVER.findElement(txtDepartDateFilter);
    }

    protected WebElement getDrbStatus(){
        return Constant.WEBDRIVER.findElement(drbStatus);
    }

    protected WebElement getBtnApplyFilter(){
        return Constant.WEBDRIVER.findElement(btnApplyFilter);
    }

    protected WebElement getBtnCancel(String no){
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable']/tbody/tr/td[1][text()='" + no + "']" +
                "/following-sibling::td/input[@type='button']"));
    }
}
