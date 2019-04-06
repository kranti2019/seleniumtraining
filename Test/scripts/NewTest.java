package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver;
	
	
	  @Test
	  public void googletest() throws InterruptedException 
	  {
		  driver.get("http://www.google.com/");
		  driver.findElement(By.name("q")).sendKeys("Jobs in Selenium");
		  Thread.sleep(5000);

		  
	  }
	
       @Test
  public void Logintest() 
     {
	     WebElement username=driver.findElement(By.id("loginname"));
		 username.sendKeys("stc123");
		 driver.findElement(By.id("loginpassword")).sendKeys("12345");
		 driver.findElement(By.id("loginbutton")).click();
		 String expectedTitle="My account";
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
  @BeforeClass
  public void beforeClass() 
  {
	  
		  //Prerequisite
			System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
			//System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
			driver=new FirefoxDriver();
		
			// driver=new ChromeDriver();
			 driver.get("http://selenium-examples.nichethyself.com/");
			 driver.manage().window().maximize();//to maximize the window
	  }
  

  @AfterClass
  public void afterClass() 
  
  {
	  driver.quit();
	  
  }

}
