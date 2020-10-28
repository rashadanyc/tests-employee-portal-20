package ui.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.helper.TestHelper;
import ui.page.AddEmployeePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class AddEmployeeTest extends TestHelper {
    private String Email = "SharaBegum879@gmail.com";
    private String email = "pinTreeBird@test.com";
    private AddEmployeePage addEmployeePage = new AddEmployeePage(driver);

    @Before
    public void setupTest() {
        //1. Navigate to 'Test Pages For Automating' home page.
        driver.get("http://cognit.mynetgear.com:3000/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void employeeAdd1() {
        addEmployeePage.clickOnAddEmployeeTab();
        addEmployeePage.setAddEmployeeFrom();
        addEmployeePage.clickOnSubmitButton();
        //ToDo assert
        Assert.assertEquals("", "", "");

    }

    @Test
    public void addEmployee2() {
        addEmployeePage.clickOnAddEmployeeTab();
        addEmployeePage.setAddEmployeeFrom();
        addEmployeePage.clickOnSubmitButton();
        //ToDo assert
        Assert.assertEquals("", "", "");

   }
}
