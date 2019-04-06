
//Assignment 9:
//. Goto http://the-internet.herokuapp.com/dropdown and select 3rd option
//2. Select any website which has all these things and try to automate.

package scripts.assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class SelectDropdown
{
	WebDriver driver;
  @Test
  public void SelectDropdown() 
  {
	  Select dropdownl = new Select(driver.findElement(By.id("dropdown")));
      assertEquals(dropdownl.getOptions().size(),3);
      dropdownl.selectByValue("2");
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	//System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
	  System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
	  //driver=new FirefoxDriver();
	   driver=new ChromeDriver();
	   driver.get("http://the-internet.herokuapp.com/dropdown");
	   driver.manage().window().maximize();//to maximize the window 
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }

}
