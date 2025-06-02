package pages;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//Login Page has methods that is used by Login Test to run test cases with common codes like opening boweser, closing broswer, finding element frequently for senarios
public class LoginPage {
	
	WebDriver driver;
	
	public void openBrowser() throws IOException {
		 
		FileInputStream f = new FileInputStream("C:\\testing\\ReadWriteProperty.properties");
		Properties prop = new Properties();
		prop.load(f);
		String browser = prop.getProperty("browser");
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
			} else if(browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
				driver = new ChromeDriver();
			}else {
				System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
				driver = new SafariDriver();
			}

		
	
	}
	
	public void openLoginPage() {
		
		 driver.get("https://auth.scotiaonline.scotiabank.com/online?auth_key=cfILP6iFe5I&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiY2ZJTFA2aUZlNUkiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzMzgxNjE5MCwiaWF0IjoxNjMzODE0OTkwLCJqdGkiOiJhNTQ4ZTlmYS1hMTAwLTRhYmQtYTljYi04YzRjZWMyZDQ4MGYiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.rf4VixjSNpA339gGpha3mK1n3891SPKiSW66Xdqb29WxSNt5UfUA2hUuWorGXCVHC69OB2sx9T6VaVajqfO8dx31hsw2lRablc8tol1HVGqSX8p4MoSUlU0fV5i9YMkJe2-twSF1tWZtImBl1GaQgM4I8fKXLjWMx1fH7vcgARvnq5aEvcRyvlf5s6nCdSeRrmPp43eOnpfL0jm87oQgei-3oeCpQm4F_hPRhvJbYjgCwbs6xIQ1emQOq0bOdbjFZk7b1rfpNI7JyqoAPUfYz1M9cmo4bWb4bQ90oLMIbUVI89pw6eTG3ZRnSigx5Q7myWl5HCyL95PgpU0h-47QWA&preferred_environment=");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	//same method for multiple senarios with different values passed via parameters.
	public void login(String username, String password) throws InterruptedException {
		
		driver.findElement(By.name("usernameInput")).sendKeys(username);
		driver.findElement(By.id("password-input")).sendKeys(password);
		driver.findElement(By.className("ButtonCore__block")).click();
		Thread.sleep(2000);
		
	}
	
	public String readGlobalError() {
		
		String globalerror = driver.findElement(By.id("globalError")).getText();
		return globalerror;
		
	}
	
	public String readLocalError() {
		
		String localerror = driver.findElement(By.className("Error__text")).getText();
		return localerror;
	}
	
	public void closeBrowser() {
		
		driver.close();
	}
	
	

}
