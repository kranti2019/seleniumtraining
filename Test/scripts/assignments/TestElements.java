
//Try all WebElement methods, isDisplayed, isEnabled,

package scripts.assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestElements 
{
	WebDriver driver;
  @Test
  public void TestElements() 
  {
	  
	  List<WebElement> links = driver.findElements(By.xpath("//a"));    //Identify the number of Link on webpage and assign into Webelement List 
      int linkCount = links.size();     // Count the total Link list on Web Page
      System.out.println("Total Number of link count on page = "  + linkCount);    //Print the total count of links on webpage
      List <WebElement> li = driver.findElements(By.tagName("a"));
  	  //For loop
      for (WebElement w1: li) 
      {
			 
          System.out.println(w1.getText()+" -  "+w1.getAttribute("href"));
       }
		
      
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      
      
     driver.findElement(By.name("q")).sendKeys("Selenium");
     
     driver.findElement(By.name("q")).clear();
     driver.findElement(By.name("q")).sendKeys("QTP");
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   // Check if Save button is displayed on the WebPage
      WebElement searchButton = driver.findElement(By.name("btnK"));
      
     
      Boolean checkSearchIsDisplayed = searchButton.isDisplayed();

      if (checkSearchIsDisplayed == true)
      {
      System.out.println("search button is displayed");
      }
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      // Check if Save button is not enabled on the WebPage

      Boolean checkSearchIsEnabled = searchButton.isEnabled();

      if (checkSearchIsEnabled == false)
      {
      System.out.println("search button is not enabled");
      }
      
         
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Label of the button is:- "+ searchButton.getAttribute("aria-label"));
      
      driver.findElement(By.name("btnK")).click();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      WebElement text=driver.findElement(By.name("q"));
      driver.findElement(By.name("q")).clear();
      text.sendKeys("selenium");
      text.submit();
      
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.navigate().to("http://www.testdiary.com/training/selenium/selenium-test-page/");
	// Using the isSelected method we check if the check box is selected or not.
	  
	  WebElement seleniumCheckbox = driver.findElement(By.id("seleniumbox"));
	 
	  Boolean checkSelenium = seleniumCheckbox.isSelected();
	 
	  // use an if condition to check if boolean returned false
	  // If false then it was not selected
	  // click and select the checkbox
	  if (checkSelenium == false) 
	  {
	  seleniumCheckbox.click();
	  System.out.println("Test has selected Selenium checkbox");
	  } else
	  {
	  System.out.println("Selenium checkbox was selected on default");
	  }
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
 
  
  
  @BeforeMethod
  public void beforeMethod()
  {
	  //System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
	  System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
	 // driver=new FirefoxDriver();
	    driver=new ChromeDriver();
	    
	   driver.get("http://www.google.com/");
	   driver.manage().window().maximize();//to maximize the window 
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
