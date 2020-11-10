package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.helper.PageHelper;

import java.util.Map;

public class ViewEmployeePage extends PageHelper {

    //private WebDriver driver;
    private By employeeTab = By.id("simple-tab-2");
    private By employeeId = By.id("..");
    private By emil = By.cssSelector("body > div.jss284 > div.jss285 > div > table > tbody > tr:nth-child(4) > td:nth-child(2)");
    //private MessageHeader ListSrting;

    public ViewEmployeePage(WebDriver webDriver) {
        this.driver = webDriver;
        //super(webDriver);
    }


    public void clickOnViewEmployee() {
        clickOnElement(employeeTab);
        clickOnElement(employeeId);

    }

    public String getText() {
        return driver.findElement(emil).getText();
    }

    public Map<String, String> getEmployeeDetailsMap() {
        By headerElement = By.xpath("");
        By columElement = By.xpath("");
        return getMap(headerElement, columElement);
    }


    public String getEmployeeNameText() {
        return null;
    }

    public String getEmployeePreviewIdText(String employeeId) {
        return null;
    }
}
