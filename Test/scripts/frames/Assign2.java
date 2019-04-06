//goto http://the-internet.herokuapp.com/frames and select the frames link 
//and navigate between frames
//Navigate in nested frames. 

package scripts.frames;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

public class Assign2 {
	public static WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String currentWindow = driver.getWindowHandle(); 
	
	  driver.findElement(By.linkText("Nested Frames")).click();
	  
	  try
	  {
		  
		  driver.switchTo().frame("frame-top");
		  
		  	  
		
      }
	  catch(NoSuchFrameException e) 
	  {
          Assert.fail("Frame was expected but not found");
	  }
	  
	  
	  try
	  {
		  driver.switchTo().frame("frame-middle");
		  WebElement msg = driver.findElement(By.tagName("body"));
	      AssertJUnit.assertEquals("MIDDLE", msg.getText());
      }
	  catch(NoSuchFrameException e) 
	  {
          Assert.fail("Frame was expected but not found");
	  }

                
         driver.switchTo().parentFrame();
	  try
	  {
		  driver.switchTo().frame("frame-left");
		  WebElement msg = driver.findElement(By.tagName("body"));
	      AssertJUnit.assertEquals("LEFT", msg.getText());
		
      }
	  catch(NoSuchFrameException e) 
	  {
          Assert.fail("Frame was expected but not found");
	  }
          
          
         driver.switchTo().parentFrame();
         
         
         try
   	     {
        	 driver.switchTo().frame("frame-right");
        	 WebElement msg = driver.findElement(By.tagName("body"));
   	         AssertJUnit.assertEquals("RIGHT", msg.getText());
   		
         }
   	  catch(NoSuchFrameException e) 
   	    {
             Assert.fail("Frame was expected but not found");
   	    }
             
          
          driver.switchTo().parentFrame();
         
          try
    	     {
         	 driver.switchTo().frame(2);
         	WebElement msg = driver.findElement(By.tagName("body"));
  	         AssertJUnit.assertEquals("RIGHT", msg.getText());
    		
          }
    	  catch(NoSuchFrameException e) 
    	    {
              Assert.fail("Frame was expected but not found");
    	    }
              
           
           driver.switchTo().defaultContent();  
    
           driver.navigate().back();
           Thread.sleep(10000);
           driver.findElement(By.linkText("iFrame")).click();
           try
     	     {
          	 driver.switchTo().frame("mce_0_ifr");
          	 WebElement msg = driver.findElement(By.tagName("body"));
     	     AssertJUnit.assertEquals("Your content goes here.", msg.getText());
     		msg.sendKeys("Kranti");
           }
     	  catch(NoSuchFrameException e) 
     	    {
               Assert.fail("Frame was expected but not found");
     	    }
               
         
  }
 
	
  
  @BeforeMethod
  public void beforeMethod() {
	  /*System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
      driver = new InternetExplorerDriver();*/
      System.setProperty("webdriver.chrome.driver", "test\\resources\\Chromedriver.exe");
      //path = c:\program files\java\jdk1.7.0.67\bin
      driver = new ChromeDriver();
      //driver = new FirefoxDriver();
      driver.get("http://the-internet.herokuapp.com/frames");
      
  }

  @AfterMethod
  public void afterMethod() {
  }

}
