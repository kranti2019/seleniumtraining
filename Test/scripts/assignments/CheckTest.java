//Select any website which has all these things and try to automate

package scripts.assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class CheckTest 
{
	WebDriver driver;
  @Test
  public void CheckTest() throws InterruptedException 
  
  {
	  WebElement restapi = driver.findElement(By.name("restapi"));
      if (!restapi.isSelected())
    	  restapi.click();
      Thread.sleep(3000);
      
      WebElement selenium = driver.findElement(By.name("selenium"));
      
      if (!selenium.isSelected())
          selenium.click();
      Thread.sleep(3000);
      
      WebElement javal = driver.findElement(By.id("java1"));
      if (!javal.isSelected())
    	  javal.click();
      Thread.sleep(3000);
     
      driver.findElement(By.linkText("Open page in a new window")).click();
      
	  Select selectShirt = new Select(driver.findElement(By.id("Shirts")));
      assertEquals(selectShirt.getOptions().size(),3);
      selectShirt.selectByIndex(1);
      Thread.sleep(10000);
      selectShirt.selectByVisibleText("Yellow Shirt");
      Thread.sleep(10000);
      selectShirt.selectByValue("blue");
      Thread.sleep(10000);
      
      Select selectSkirt = new Select(driver.findElement(By.id("Skirts")));
      assertEquals(selectSkirt.getOptions().size(),3);
      selectSkirt.selectByIndex(0);
      Thread.sleep(10000);
      selectSkirt.selectByVisibleText("Red Skirt");
      Thread.sleep(10000);
      selectSkirt.selectByValue("YellowSkirt");
      Thread.sleep(10000);
      driver.findElement(By.linkText("Test Diary")).click();
      
      
      
//      driver.findElement(By.id("//button[@id='demo']")).click();
//      Thread.sleep(10000);
//	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  //System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
	  System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
	 // driver=new FirefoxDriver();
	    driver=new ChromeDriver();
	    
	   driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
	   driver.manage().window().maximize();//to maximize the window 
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
