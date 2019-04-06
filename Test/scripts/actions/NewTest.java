package scripts.actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class NewTest {
	private WebDriver driver;
    WebDriverWait wait;
  @Test
  public void Assignment3() throws InterruptedException
  {
	  
	  driver.get("http://triphobo.com/");
	  //PropertyConfigurator.configure("log4j.properties");
	  Set<String> AllWindowHandles = driver.getWindowHandles();
	  String window1 = (String) AllWindowHandles.toArray()[0];
	  System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
	
	 //- Click "Later" in be updated box
	  WebElement element = driver.findElement(By.xpath("//button[contains(.,'Later')]"));
	  element.click();
	  String parentWindowHandle = driver.getWindowHandle();
	 //- Houston in Texas
	  WebElement element1 = driver.findElement(By.xpath("//input[@type='search']"));
	  element1.sendKeys("Houston");
	  element1.submit();
	  // wait until the google page shows the result
      WebElement myDynamicElement = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='js-suggestions-active places-search-list']")));

      List<WebElement> list = driver.findElements(By.xpath("//li[@class='item']"));
      
      
     
      System.out.println("Size of list:"+list.size());

      // this are all the links you like to visit
      for(int i=0;i<list.size();i++)
      {
    	  
          System.out.println(list.get(i).getText());
          if(list.get(i).getText().contains("Houston , Texas, United States, North America"))
          {
        	  list.get(i).click();
        	  WebElement planmytrip =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='plan-my-trip']")));
        	  planmytrip.click();
        	 // driver.findElement(By.xpath("//a[@id='plan-my-trip']")).click();
        	  break;
          }        
          
          
      }
      //- Click on "Skip to Plan" again on the box
      WebElement mo3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='js_proceed_accommodation_planning btn-success btn-primary btn js-monitor-this btn-success btn let-me-plan']")));
      mo3.click();
      WebElement mo4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='btn btn-success pull-right close-hotel-combine']")));
      mo4.click();
      WebElement mo5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='hotel_step_popup_skip_hotel']")));
      mo5.click();
    
     // WebElement mo6 = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//a[@id='close']"))));
      
    
      WebElement mo6 =(new WebDriverWait(driver, 70)).until(ExpectedConditions.elementToBeClickable((By.id("close"))));
      mo6.click();
//      WebElement mo15 =(new WebDriverWait(driver, 70)).until(ExpectedConditions.elementToBeClickable((By.xpath("//a[contains(@class,'js-monitor-me')]"))));
//      mo15.click();
    //a[contains(@class,'js-monitor-me')]
      WebElement mo7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='js_add_activity']")));
      mo7.click();
    //  Thread.sleep(10000);
//      List<WebElement> list1 = driver.findElements(By.xpath("//a[@title='Click To Add']"));
//      
//      System.out.println("Size of list1:"+list1.size());
      WebElement mo12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[contains(@class,'add-to-plan')])[4]")));
      Actions builder2 = new Actions(driver);
      builder2.moveToElement(mo12).click().perform();
      
//      WebElement mo8 =(new WebDriverWait(driver,60)).until(ExpectedConditions.visibilityOfElementLocated(By.
//    		xpath("//div//div//a[@title='Click To Add']")));
//      Actions builder1 = new Actions(driver);
//      builder1.moveToElement(mo8).click().perform();
//      
    
    
      WebElement mo9 = (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.
      		xpath("//a[@data-day='2']")));
      mo9.click();
     // Thread.sleep(10000);
//      String window2 = (String) AllWindowHandles.toArray()[1];
//	  System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
//	 
      
//      WebElement mo10 = (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.
//        		xpath("//div[@data-unique-id='activity_drawer']//div[@class='global-side-drawer']//a[@id='close']")));
     // driver.switchTo().defaultContent();
     
      WebElement mo10 = (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//a[contains(@class,'js-monitor-me js_side_drawer_close')])[2]"))));
        mo10.click();
        
        
        WebElement mo11 = (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(("//a[@class='js-monitor-me js_side_drawer_close']")))));
        mo11.click();
      
//      WebElement mo10 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.
//        		xpath("//div[@class='accomodation-hotel-combine-header js_ad_activity_header']")));
//      mo10.click();
//   
  }
      
      
  
     
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      wait= new WebDriverWait(driver,60,250);
  
  }
  
      
  

  @AfterMethod
  public void afterMethod() 
  {
  }

}
