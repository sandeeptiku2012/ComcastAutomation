package VideoManagement.VideoSearchFunctionality.SearchVideoByCategory;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;

import ConfigServices.DataServiceProperties;
import ConfigServices.Utils.BaseTest;
import Core.UserManagement.UserLoginFunctions.UserLoginFunctions;
import DataServices.UserRegistrationUsingComcastApplication.UserRegistrationUsingComcast;

public class EnsureSearchChannelStoreIsWorkingFine extends BaseTest{
 UserLoginFunctions userLogin=new UserLoginFunctions();
 UserRegistrationUsingComcast userReg=new UserRegistrationUsingComcast();
 
  @Test
  public void testEnsureSearchChannelStoreIsWorkingFine() throws Exception {
	
	userReg.testUserRegistrationUsingComcast(driver);
	  
	driver.get(DataServiceProperties.APPURL);
	  
	userLogin.UserLoginCredentials(driver);
	    
    userLogin.ChangePassword(driver);
    Thread.sleep(2000);
	
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*HOME[\\s\\S]*$"));
    
    driver.findElement(By.id("search-query")).clear();
    driver.findElement(By.id("search-query")).sendKeys("Avatar");
    driver.findElement(By.id("go-search")).click();
    Thread.sleep(2000);
   
    try {
    	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Results for 'Avatar'[\\s\\S]*$"));
       } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Sign out")).click();
  }
}

