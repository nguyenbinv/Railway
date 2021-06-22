package Testcases.Railway;

import Common.Constant.Constant;
import Common.Utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class BaseTest {

    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeTest
    public void startReport() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/RailwayReport.html", true);
        extent
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Huy Nguyen");
        extent.loadConfig(new File(Common.Utilities.Utilities.getProjectPath() + "/extent-config.xml"));
    }

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser) throws Exception {
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
        Dimension d = new Dimension(1300, 1400);
        Constant.WEBDRIVER.manage().window().setSize(d);
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "<b>" + result.getName() + " IS FAILED</b>");
            logger.log(LogStatus.FAIL, "<b>THE ERROR:</br>" + result.getThrowable() + "</b>");
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "<b>" + result.getName() + "IS SKIPPED</b>");
        }
        extent.endTest(logger);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Post-Condition");
        Constant.WEBDRIVER.quit();
    }

    @AfterTest
    public void endReport() {
        extent.flush();
        extent.close();
    }

}
