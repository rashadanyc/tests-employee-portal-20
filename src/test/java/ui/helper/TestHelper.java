package ui.helper;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;

public class TestHelper {

    @Rule
    ErrorCollector errorCollector = new ErrorCollector();
    public static WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        driver = CommonHelper.loadDriver("chrome");
        driver.get("http://cognit.mynetgear.com:3000/");

    }

    //  @AfterClass
//    public static void teardowne() {
//        CommonHelper.quitDriver();
//    }


}
/*
public void verifyEquals(String message,String expected,String actual){
try{
  assertEquals(message,expected,actual);
}catch(AsserionEeeor e){
    errorCollection.addError(e);
}
}


public void varifyTrue(String message,boolean actualCondition){
try{
  assertTrue(message,actualCondition);
}catch(AssertionError e){
  errorClllection.addError(e);
}
}

public void varifyFalse(String message,boolean actualCondition){
try{
  assertFalse(message,actualCondition);
}catch(AssertionError e){
  errorClllection.addError(e);
}
}
 */