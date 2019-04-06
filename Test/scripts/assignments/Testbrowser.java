// Try all the navigate methods, getPageSource(), getCurrentUrl, maximize

package scripts.assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Testbrowser 
{
	WebDriver driver;
	
	


  @Test
  public void Testbrowser1() throws InterruptedException 
  {
	  String currentURL;
      currentURL = driver.getCurrentUrl();
      System.out.println(currentURL);
      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      
      
      driver.navigate().refresh();
	  String expectedFlipkartPageTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";      
	  //Get page title
	  String actualFlipkartTitle=driver.getTitle();
	  System.out.println("Flipkart page title"+"-" + actualFlipkartTitle);   
	  //Verify expected page title and actual page title is same  
	  Assert.assertTrue(actualFlipkartTitle.equalsIgnoreCase(expectedFlipkartPageTitle),"Page title not matched or Problem in loading url page");     
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	  List<WebElement> flipkartlinks=driver.findElements(By.xpath("//div[@id='container']/*[1]"));
	  //For loop
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      for (int j = 0; j < flipkartlinks.size(); j++) 
	      
     {
      System.out.println(flipkartlinks.get(j).getText()+" -  "+flipkartlinks.get(j).getAttribute("id"));
	        
     }
     System.out.println("Size of elements"+"-"+ flipkartlinks.size());
 
     //driver.findElement(By.linkText("Login & Signup")).click();
     driver.findElement(By.xpath("//input[@class='_2zrpKA']")).sendKeys("kranti.patil8@gmail.com");
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    // driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
     driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv']")).sendKeys("kranti2018");
     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     
	  
     
     Boolean b =  driver.getPageSource().contains("Online Shopping in India,online Shopping store,Online Shopping Site,Buy Online,Shop Online,Online Shopping,Flipkart");
     System.out.println("Value of b" +"-"+ b);
     JavascriptExecutor jsx = (JavascriptExecutor)driver;
  
     jsx.executeScript("window.scrollBy(0,1500)", ""); //scroll down
   
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  
     jsx.executeScript("window.scrollBy(400,0)", ""); //scroll up
     
     driver.navigate().to("http://www.amazon.in/");

     //To navigate back (Same as clicking on browser back button)
     driver.navigate().back();

     //To navigate forward (Same as clicking on browser forward button)
     driver.navigate().forward();
     
			
	
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  //System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
	  System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
	 // driver=new FirefoxDriver();
	    driver=new ChromeDriver();
	    
	   driver.get("http://www.flipkart.com/");
	   driver.manage().window().maximize();//to maximize the window 
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	   
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
