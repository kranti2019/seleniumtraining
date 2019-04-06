package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class NewTestNGTest {
	WebDriver driver;
  @Test
  public void TestLogin() 
  {
	     WebElement username=driver.findElement(By.id("loginname"));
		 username.sendKeys("stc123");
		 driver.findElement(By.id("loginpassword")).sendKeys("12345");
		 driver.findElement(By.id("loginbutton")).click();
		 String expectedTitle="My account1";
		 String actualTitle=driver.getTitle();
//		 if(expectedTitle.equals(actualTitle))
//		 {
//			 System.out.println("Login test case passed!");
//		 }
//		 else
//		 {
//			 System.out.println("Login test case failed!");
//		 }
		 assertEquals(actualTitle,expectedTitle,"Login test case failed!");
				 
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  //Prerequisite
		System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
		//System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
		driver=new FirefoxDriver();
	
		// driver=new ChromeDriver();
		 driver.get("http://selenium-examples.nichethyself.com/");
		 driver.manage().window().maximize();//to maximize the window
  }

  @AfterMethod
  public void afterMethod()
  {
	  //closing resources
	  driver.quit();
  }

}
