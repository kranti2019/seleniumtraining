package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class YahooTest 
{
	WebDriver driver;
  @Test
  public void YahooTest() throws InterruptedException 
  {
	  
	     WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		 username.sendKeys("vaishali_vp2004");
		 driver.findElement(By.xpath("//input[@name='signin']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("kranti@2020");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(5000);
		
}
@BeforeClass
public void beforeClass() 
{
	//Prerequisite
		System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
		//System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
		driver=new FirefoxDriver();
	
		 //driver=new ChromeDriver();
		 driver.get("https://login.yahoo.com/");
		 driver.manage().window().maximize();//to maximize the window
}

@AfterClass
public void afterClass()
{
	 driver.quit();
}

}
