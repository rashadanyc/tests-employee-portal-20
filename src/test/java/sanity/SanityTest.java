package sanity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.helper.TestHelper;

public class SanityTest extends TestHelper {


    @Before
    public void setupTest() {
        //1. Navigate to 'Test Pages For Automating' home page.
        driver.get("http://cognit.mynetgear.com:3000/");
    }

    @Test
    public void empPortalDashboradPageload() {
        String expectedHeader = "Cognit Employee Portal";
        String actualHeader = driver.findElement(By.cssSelector("#root header h1")).getText();
        Assert.assertEquals("Dashboard header title not matched.", expectedHeader, actualHeader);
    }
}



