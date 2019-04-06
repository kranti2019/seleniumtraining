package scripts.poi.excel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class LoginTest {
	WebDriver driver;
    WebDriverWait wait;
    ReadLoginTest rd;
  @Test(dataProvider = "getLoginData")
  public void LoginTest(String user, String pass) 
  {
	  WebElement username=driver.findElement(By.name("identifier"));
	     username.sendKeys(user);
		 driver.findElement(By.xpath("//content[contains(.,'Next')]")).click();
		 
		 WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		 pwd.sendKeys(pass);
		 driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  //Prerequisite
		System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
		//System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
		driver=new FirefoxDriver();
	
		 //driver=new ChromeDriver();
		 driver.get("https://accounts.google.com/");
		 driver.manage().window().maximize();//to maximize the window
		 wait= new WebDriverWait(driver,30,250);
  }

  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }


  @DataProvider
  
  public Object[][] getLoginData() throws IOException
  {
	  Object[][] data= rd.readExcel("LoginData");
	  
	  return data;
   
  }
}
