
//Assignemtn 8 - steps given below
// 1. go to wikipedia.org
//2. Click on English Link
//3. Type "Selenium" in search field
//4. Click on search button
//5. Verify whether the title is "Selenium - Wikipedia"
//6. Check if heading is "Selenium"
package scripts.assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class WiKiTest 
{
	WebDriver driver;
  @Test
  public void WiKiTest() 
  {
	  driver.findElement(By.xpath("//strong[contains(text(),'English')]")).click();
	  driver.findElement(By.name("search")).sendKeys("Selenium");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.name("go")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	  String expectedTitle="Selenium - Wikipedia";
		 String actualTitle=driver.getTitle();
		 if(expectedTitle.equals(actualTitle))
		 {
			 System.out.println("page title is correct");
		 }
		 else
		 {
			 System.out.println("page title is incorrect");
		 }
		 String expectedHeading="Selenium";
		 String actualHeading=driver.findElement(By.id("firstHeading")).getText();
		 if(expectedHeading.equals(expectedHeading))
		 {
			 System.out.println("heading is correct");
		 }
		 else
		 {
			 System.out.println("heading is incorrect");
		 }
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	//System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
	  System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
	  //driver=new FirefoxDriver();
	   driver=new ChromeDriver();
	   driver.get("https://www.wikipedia.org/");
	   driver.manage().window().maximize();//to maximize the window 
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
