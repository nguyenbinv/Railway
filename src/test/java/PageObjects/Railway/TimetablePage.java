package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage {
    //Elements
    protected WebElement getCheckPrice(String departStation, String arriveStation, String departTime, String arriveTime) {
        return Constant.WEBDRIVER.findElement(By.xpath("//tbody/tr/td[text()='" + departStation + "']" +
                "/following-sibling::td[text()='" + arriveStation + "']" +
                "/following-sibling::td[text()='" + departTime + "']" +
                "/following-sibling::td[text()='" + arriveTime + "']/following-sibling::td[1]"));
    }

    protected WebElement getBookTicket(String departStation, String arriveStation, String departTime, String arriveTime) {
        return Constant.WEBDRIVER.findElement(By.xpath("//tbody/tr/td[text()='" + departStation + "']" +
                "/following-sibling::td[text()='" + arriveStation + "']" +
                "/following-sibling::td[text()='" + departTime + "']" +
                "/following-sibling::td[text()='" + arriveTime + "']/following-sibling::td[2]"));
    }

    //Methods
    public BookTicketPage bookTicket(String departStation, String arriveStation, String departTime, String arriveTime) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollBy(0,350)", "");
        this.getBookTicket(departStation, arriveStation, departTime, arriveTime).click();
        return new BookTicketPage();
    }
}
