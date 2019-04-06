//Assignment1  ( Do this after 10th March  )
//1. Go to google.com
//2. Click on Gmail link such that it opens in the same window in a new tab
//3. then login into Gmail.
//4. Come back to google.com tab and search on "jobs in Selenium"



package scripts.actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Assignment5 
{
	WebDriver driver;
    WebDriverWait wait;
  @Test
  public void Assignment5() throws InterruptedException 
  {
	  driver.get("https://www.google.com/");
	  // Get and store both window handles in array
	  Set<String> AllWindowHandles = driver.getWindowHandles();
	  String window1 = (String) AllWindowHandles.toArray()[0];
	  System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
	  WebElement contextArea = driver.findElement(By.xpath("//a[@class='gb_d'][contains(.,'Gmail')]"));
	  String window2 = (String) AllWindowHandles.toArray()[1];
	  System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
    
      Actions builder = new Actions(driver);

     builder.contextClick(contextArea).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER)).build().perform();
    
	 // driver.switchTo().window(window2);
      	  
         driver.findElement(By.linkText("Sign in")).click();
        WebElement username=driver.findElement(By.name("identifier"));
	     username.sendKeys("kranti.patil8@gmail.com");
		 driver.findElement(By.xpath("//content[contains(.,'Next')]")).click();
		 
		 WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		 pwd.sendKeys("kranti@2020");
		 driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
		 Thread.sleep(10000);
		 driver.switchTo().window(window1);
		 WebElement txt1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		 txt1.sendKeys("jobs in Selenium");
		 Thread.sleep(10000);
		 
  }
  @BeforeMethod
  public void beforeMethod() 
    {
	  
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
      System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
      //driver = new FirefoxDriver();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      wait= new WebDriverWait(driver,30,250);
      //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     
  }

  @AfterMethod
  public void afterMethod() {
  }

}
