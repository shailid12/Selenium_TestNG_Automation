package test;

import org.testng.annotations.Test;

import data.DataClass;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

//This has test cases for login function which calls methods of Login page to access and run common codes for the test cases.
public class LoginTest {
	
  LoginPage lp = new LoginPage();
  DataClass dc = new DataClass();
  
  
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  lp.openBrowser();
	  lp.openLoginPage();
  }

  
  @Test
  public void loginWithWrongEmailPasswordTest() throws InterruptedException {

	  lp.login(dc.wrong_email, dc.wrong_password);
	  String actualError = lp.readGlobalError();
	  Assert.assertEquals(dc.global_exp_error, actualError);
	  
	
  }

  @Test
  public void loginWithEmptyEmailTest() throws InterruptedException {
	  
	  lp.login("", dc.wrong_password);
	  String actualError = lp.readLocalError();
	  Assert.assertEquals(dc.empty_email_error, actualError);
	  
  }
  
  @Test
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	  
	  //Parameters for login method of login page
	  lp.login(dc.wrong_email, "");
	  String actualError = lp.readLocalError();
	  Assert.assertEquals(dc.empty_password_error, actualError);
	  
  }
  
  @Test
  public void loginWithInvalidEmailTest() throws InterruptedException {
	  
	  lp.login(dc.invalid_email, dc.wrong_password);
	  String actualError = lp.readLocalError();
	  Assert.assertEquals(dc.invalid_email_error, actualError);
	
  }
  
  @AfterMethod
  public void afterMethod() {
	  
	  lp.closeBrowser();
	
	  
  }
  
}
