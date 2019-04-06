package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class NewTest1 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException
  {
	  driver.findElement(By.xpath("//div[@id='start']/button")).click();
	  //Thread.sleep(10000);
	 
	  String actualresult=driver.findElement(By.id("finish")).getText();
	  String expectedresult="Hello World!";
	  assertEquals(expectedresult,actualresult);
	  
  }
  @BeforeMethod
  public void beforeMethod()
  {
	  System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
		//System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
		driver=new FirefoxDriver();
		 
		// driver=new ChromeDriver();
		 driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		 driver.manage().window().maximize();//to maximize the window
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }

}
