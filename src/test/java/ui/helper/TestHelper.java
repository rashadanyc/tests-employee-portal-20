package ui.helper;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHelper {

    public static WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }
//    @AfterClass
//    public static void teardowne() {
//        driver.quit();
//    }


}
