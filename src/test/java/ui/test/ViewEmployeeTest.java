package ui.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.helper.TestHelper;
import ui.page.ViewEmployeePage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ViewEmployeeTest extends TestHelper {
    @Before
    public void setupTest() {
        //1. Navigate to 'Test Pages For Automating' home page.
        driver.get("http://cognit.mynetgear.com:3000/");
    }

    @Test
    public void viewEmployeePreviewBox() {
        String employeeName = "jjj";
        String employeeId = "907";
        //String email="sdsdsd@gmail.com";

        String employeName = new ViewEmployeePage(driver).getEmployeeNameText();
        String expected = null;
        verifyEquals("Failed-Employee Name not matched", expected, employeeName);

        String actualId = new ViewEmployeePage(driver).getEmployeePreviewIdText(employeeId);
        verifyEquals("Failed-Employee Id not matched  on employee preview Box", expected, employeeId);
    }

    public void verifyEquals(String message, String expected, String actual) {
        assertEquals(message, expected, actual);
    }


    @Test
    public void viewEmployee() {
        WebDriverWait time = new WebDriverWait(driver, 32);
        WebElement element = time.until(ExpectedConditions.visibilityOfElementLocated(By.id("622")));
        driver.findElement(By.id("622")).click();
        List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[2]/div[3]/div/table/tbody/tr[2]/td[2]"));
        List<String> ViewEmployee = new ArrayList<String>();
        for (int i = 0; i < elements.size(); i++) {

            ViewEmployee.add(elements.get(i).getText());

        }
        List<String> expectedArrayList = new ArrayList<String>();
        expectedArrayList.add("First Name Rose");
        expectedArrayList.add("Last Name Chowdhury");

        // List<String> stringList = new EmployeesPage(driver).getEmployeeListOfNameFromPreviewBox();
        //assertTrue("Failed - Employee preview box Employee ID not found.", stringList.contains("Employee Id: 622"));
        // Assert.assertTrue("Faile - Employee preview box Employee ID not found", StringList.contains("Employee ID:622"));
//        assertTrue("Failed - Employee preview box Employee ID not found.", stringList.contains("Employee Id: 622"));
//        assertTrue("Failed - Employee preview box Employee Name not found.", stringList.contains("Rose Chowdhury"));

        Assert.assertTrue(ViewEmployee.containsAll(expectedArrayList));
    }


}

/*public void verifyequals(String message, expected,act..){
try{
    assertEqals(message,expected,actual);

}catch(AssertionError e){
   errCollector.addError(e);
}
 */

