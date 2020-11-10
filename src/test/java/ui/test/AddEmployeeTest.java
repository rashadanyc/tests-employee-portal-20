package ui.test;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import ui.helper.CommonHelper;
import ui.helper.TestHelper;
import ui.page.AddEmployeePage;

import static org.junit.Assert.assertTrue;

public class AddEmployeeTest extends TestHelper {

    private AddEmployeePage addEmployeePage = new AddEmployeePage(driver);

    @Test
    public void employeeAdd1() {
        String firstName = "lll"; //RandomStringUtils.randomAlphabetic(10);
        String lastName = "hhhh"; //RandomStringUtils.randomAlphabetic(10);
        String email = firstName + lastName + RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
        addEmployeePage.clickOnAddEmployeeTab();
        addEmployeePage.setAddEmployeeFrom(firstName,
                lastName,
                email,
                "690658378283",
                "10/09/2020",
                "3000",
                "0.6",
                "AC_ACCOUNT",
                "122",
                "IT");
        addEmployeePage.clickOnSubmitButton();
        //todo assert
        String actualMessage = addEmployeePage.getFromSubmissionStatusMessage();
        String empId = CommonHelper.getEmloyeeId(lastName);
        String expectedSuccessMessage = "Following employee has been saved : Name: " + firstName + " " + lastName + " employee Id:" + empId;
        assertTrue("Message did not match", actualMessage.contains(expectedSuccessMessage));

    }


}


//    @Test
//    public void addEmployee2() {
//        addEmployeePage.clickOnAddEmployeeTab();
//        addEmployeePage.setAddEmployeeFrom("","" ,"","","" ,"" ,"","");
//        addEmployeePage.clickOnSubmitButton();
//        //ToDo assert
//        Assert.assertEquals("message does not match", "Failed to add employees. Add employee success message is found", "");

// }
//}
