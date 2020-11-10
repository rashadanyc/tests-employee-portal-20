package ui.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.*;
import java.util.concurrent.TimeUnit;


public class CommonHelper extends Constants {

    public static WebDriver driver;
    private static String propertyName;

    public static WebDriver loadDriver() {
        String driverType = System.getenv("DRIVER_TYPE");
        if (driverType == null || driverType != "") {
            driverType = Constants.DEFAULT_DRIVER;
        }
        return loadDriver(driverType);
    }

    public static WebDriver loadDriver(String driverType) {
        if (driverType.equalsIgnoreCase("chrome")) {
            String env = System.getenv("DRIVER_TYPE");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");//?
            driver = new ChromeDriver(chromeOptions);
        } else if (driverType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.geckodriver.driver", "src/test/resources/driver/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (driverType.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println("you did not set any driverType,please set driverType ");
        }
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT_SECOND_THIRTY, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_SECOND, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

//    public static String quitDriver(String lastName) {
//        if (driver != null) {
//            driver.quit();
//        }


    public static String getEmloyeeId(String lastName) {
        Connection connection = null;
        String username = "hr";
        String password = "hr";
        String employeeId = "856";

        //Coneect to the database
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@cognit.mynetgear.com:1521:xe", username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select employee_id form employees where last_name ='" + lastName + employeeId);
            if (resultSet.next()) {
                //Get column value by column name
                employeeId = resultSet.getString("employee_id");
                //return employeeId;
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return employeeId;
        }


    }


}






