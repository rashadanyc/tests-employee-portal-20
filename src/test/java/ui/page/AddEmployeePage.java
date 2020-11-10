package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.helper.PageHelper;

import static javax.swing.UIManager.getString;

public class AddEmployeePage extends PageHelper {

    // private WebDriver driver;
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emilField = By.id("email");
    private By phoneField = By.xpath("//*[@id=\"simple-tabpanel-1\"]/div/form/div[2]/div[4]/div/div/input");
    private By hireDateField = By.id("hireDate");
    private By salaryField = By.id("salary");
    private By commissionsPct = By.id("commisionPct");
    private By jobIdListField = By.xpath("//*[@id=\"simple-tabpanel-1\"]/div/form/div[2]/div[8]/div/div/div");
    // private By jobCodeElement = By.cssSelector("[data-value='AC_ACCOUNT']");
    //private By jobIdElementField = By.cssSelector("[data-value='IT_PROG']");
    private By managerIdListField = By.xpath("//*[@id=\"simple-tabpanel-1\"]/div/form/div[2]/div[9]/div/div/div");
    // private By managerIdField = By.cssSelector("[data-value='100']");
    private By departmentListField = By.cssSelector("#simple-tabpanel-1 > div > form > div.eeAddControls > div:nth-child(18) > div > div > div");
    private String departmentIdField = "[data-value='%s']";
    private By successMessage = By.id("client-snackbar");

    public AddEmployeePage(WebDriver driver) {
        // super(driver);
        this.driver = driver;

    }


    public void clickOnAddEmployeeTab() {
        driver.findElement(By.id("simple-tab-2")).click();
    }

    public void clickOnElement(By locator, String value) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        //driver.findElement(locator).clear();
    }

    public void setAddEmployeeFrom(String firstName, String lastName, String email, String phone, String hireDate, String salary, String commissionPct, String jobCode, String managerIdField, String departmentIdField) {
        //clickOnAddEmployeeTab();
        setField(firstNameField, firstName);
        setField(lastNameField, lastName);
        setField(emilField, email);
        setField(phoneField, phone);
        setField(hireDateField, hireDate);
        setField(salaryField, salary);
        setField(commissionsPct, commissionPct);

        clickAndSelect(jobIdListField, jobCode);
        clickAndSelect(managerIdListField, managerIdField);
        clickAndSelect(departmentListField, departmentIdField);

    }


    public void clickOnSubmitButton() {
        driver.findElement(By.xpath("//*[@id=\"simple-tabpanel-1\"]/div/form/div[2]/div[11]/button/span[1]")).click();

    }

    public String getFromSubmissionStatusMessage() {
        return getString(successMessage).trim();
    }

    public String getText(By by) {
        return driver.findElement(by).getText().trim();
    }
}
