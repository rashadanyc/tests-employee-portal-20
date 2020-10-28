package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {

    private WebDriver driver;
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emilField = By.id("email");
    private By phoneField = By.xpath("//*[@id=\"simple-tabpanel-1\"]/div/form/div[2]/div[4]/div/div/input");
    private By hireDateField = By.id("hireDate");
    private By salaryField = By.id("salary");
    private By commitionptc = By.id("commisionPct");
    private By jobIdElementField= By.cssSelector("#simple-tabpanel-1 > div > form > div.eeAddControls > div:nth-child(16) > div > div > div");
    private By jobIdListField=By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[10]");
    private By managerIdElementField =By.xpath("//*[@id=\"simple-tabpanel-1\"]/div/form/div[2]/div[9]/div/div/div");
    private By managerIdLstField = By.xpath("//*[@id=\"menu-\"]/div[3]/ul/li[5]");
    private By departmentId=By.xpath("//*[@id=\"simple-tabpanel-1\"]/div/form/div[2]/div[10]/div/div/div");
    //private By jobIdField =By.
    //private By jodField=By.();


    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;

    }

    public void clickOnAddEmployeeTab() {
        driver.findElement(By.id("simple-tab-2")).click();
    }

    public void setField(By locator, String value) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(value);

    }

    public void clickOnElement(By locator, String value) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public void setAddEmployeeFrom() {

        setField(firstNameField, "PinTree");
        setField(lastNameField, "Bird");
        setField(emilField, "pinTreeBird@test.com");
        setField(phoneField, "917-000-3982");
        setField(hireDateField, "5/10/2020");
        setField(salaryField, "300000");
        setField(commitionptc, "0.10");
        clickOnElement(jobIdElementField, "jobId");
        clickOnElement(jobIdListField, "IT-PROG");
        clickOnElement(managerIdElementField, "ManagerId");
        clickOnElement(managerIdLstField,"103");
        clickOnElement(departmentId, "DepartmentId");


    }

    public void clickOnSubmitButton() {
        driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-1\"]/div/form/div[2]/div[11]/button/span[1]")).click();

    }
}
