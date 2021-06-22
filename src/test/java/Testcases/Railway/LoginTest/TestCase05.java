package Testcases.Railway.LoginTest;

import Common.Constant.Constant;
import PageObjects.Railway.*;
import Testcases.Railway.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase05 extends BaseTest {
    private HomePage homePage = new HomePage();

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        logger = extent.startTest("TC05 - System shows message when user enters wrong password several times");

        logger.log(LogStatus.PASS,"1. Navigate to QA Railway Website");
        homePage.open();

        logger.log(LogStatus.PASS,"2. Click on \"Login\" tab");
        LoginPage loginPage = homePage.gotoLoginPage();

        logger.log(LogStatus.PASS,"3. Enter valid information into \"Username\" textbox except \"Password\" textbox");
        logger.log(LogStatus.PASS,"4. Click on \"Login\" button");
        logger.log(LogStatus.PASS,"5. Repeat step 3 three more times.");
        for (int i = 0; i < 4; i++) {
            JavascriptExecutor jse = (JavascriptExecutor) Constant.WEBDRIVER;
            jse.executeScript("scroll(0, 9000)");
            loginPage.login(Constant.USERNAME, "abcd1111");
        }

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualMsg, expectedMsg, "Login error message is not displayed as expected");
    }
}
