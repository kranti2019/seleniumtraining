//Five different ways of doing refresh in WebDriver
package scripts.assignments;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class RefreshTest 
{
	WebDriver driver;
  @Test
  public void RefreshTest()
  {
	  // Technique1
	  driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).sendKeys("kranti");
	  
	  driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).sendKeys(Keys.F5);
	  
	  // Technique2
	  driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys("\uE035");
	  driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys("patil");
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  //System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
	  System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
	   //driver=new FirefoxDriver();
	   driver=new ChromeDriver();
	   driver.get("https://accounts.google.com/SignUp");
	   // Technique3
	   driver.navigate().to(driver.getCurrentUrl());
	   driver.manage().window().maximize();//to maximize the window 
	   // Technique4
	   driver.navigate().refresh();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   // Technique5
	   driver.get(driver.getCurrentUrl());
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
