package ui.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageHelper {

    public static WebDriver driver;

    public void clickOnElement(By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void setField(By locator, String value) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void clickAndSelect(By dropDownElement, String visibleSting) {
        if (visibleSting != "" || visibleSting != null) {
            clickOnElement(dropDownElement);
            clickOnElement(By.cssSelector("[data-value='" + visibleSting.toUpperCase() + "']"));

        }

    }

    public Map<String, String> getMap(By headerElement, By columElement) {
        Map<String, String> employeeDetailMap = new HashMap();


        List<String> headerList = getStringList(headerElement);
        List<String> valueList = getStringList(headerElement);

        for (int i = 0; i < headerList.size(); i++) {
            employeeDetailMap.put(headerList.get(i), valueList.get(i));

        }
        return employeeDetailMap;


    }

    public List<String> getStringList(By by) {
        List listString = new ArrayList();
        List<WebElement> elements = driver.findElements(by);
        for (WebElement element : elements) {
            //List.add(element.getText());
        }

        return listString;

    }

    /**
     * JavascriptExecutor to interact with the browser elements.
     * Use these instead of sendKeys(), click() if facing challenges to interact on special UI framework.
     *
     * @param elementId
     * @param value
     */
    public void jsExecutorEnterById(String elementId, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsById('" + elementId + "')[0].value='" + value + "'");
    }
}

