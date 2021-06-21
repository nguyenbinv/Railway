package Common.Constant;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railway2.somee.com";
    public static final String USERNAME = System.getenv("username");
    public static final String PASSWORD = System.getenv("password");
    public static final String NEW_PASSWORD = System.getenv("new_password");
}
