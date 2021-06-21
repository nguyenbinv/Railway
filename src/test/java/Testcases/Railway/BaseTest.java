package Testcases.Railway;

import Common.Constant.Constant;
import Common.Utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) throws Exception {
        System.out.println("Pre-Condition");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() +
                    "/src/test/java/Executables/chromedriver.exe");
            Constant.WEBDRIVER = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            Constant.WEBDRIVER = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            Constant.WEBDRIVER = new EdgeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
        Dimension d = new Dimension(1300,1400);
        Constant.WEBDRIVER.manage().window().setSize(d);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-Condition");
        Constant.WEBDRIVER.quit();
    }

}
