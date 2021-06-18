package Testcases.Railway;

import Common.Constant.Constant;
import Common.Utilities.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-Condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() +
                "/src/test/java/Executables/chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-Condition");
        Constant.WEBDRIVER.quit();
    }

}
