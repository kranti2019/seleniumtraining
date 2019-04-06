//Assignment1
//go to https://www.toolsqa.com/iframe-practice-page/ and 
//switch between multiple frames

package scripts.frames;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

public class Assign1 
{
	 public static WebDriver driver;
  @Test
  public void ToolQAFrame1() throws InterruptedException 
  {
	//Finding iframe
	  
	  List<WebElement> frames = driver.findElements(By.tagName("iframe"));
	 
	  int numberOfTags = frames.size();
	
	  System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);
	  
//	  for(WebElement frame : frames)
//	  {
//          //switchTo().frame() also accepts frame elements apart from id, name or index 
//          driver.switchTo().frame(frame);
//          
//      }
	  try
	  {
		 driver.switchTo().frame("iframe1");//id attribute or a name attribute of frame element
      }
	  catch(NoSuchFrameException e) 
	  {
          Assert.fail("Frame was expected but not found");
	  }
//	  String currentWindow = driver.getWindowHandle(); 
//      
//      driver.switchTo().frame("iframe1");
	  Thread.sleep(10000);
      driver.findElement(By.linkText("Partial Link Test")).click();
       
      WebElement firstname=driver.findElement(By.name("firstname"));
      firstname.sendKeys("Kranti");
      System.out.println("First name is"+"-"+firstname.getAttribute("value"));
       
      WebElement lastname=driver.findElement(By.name("lastname"));
      lastname.sendKeys("Patil");
      System.out.println("Last name is"+"-"+lastname.getAttribute("value"));
      driver.switchTo().defaultContent();
      Thread.sleep(10000);
      try
	  {
		 driver.switchTo().frame("iframe2");//id attribute or a name attribute of frame element
      }
	  catch(NoSuchFrameException e) 
	  {
          Assert.fail("Frame was expected but not found");
	  }
      WebElement rightmsg = driver.findElement(By.tagName("h1"));
      System.out.println(rightmsg.getText());
      AssertJUnit.assertEquals("Error establishing a database connection", rightmsg.getText());
  }
  
  @BeforeMethod
  public void beforeMethod()
  {
	  /*System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
      driver = new InternetExplorerDriver();*/
      System.setProperty("webdriver.chrome.driver", "test\\resources\\Chromedriver.exe");
      //path = c:\program files\java\jdk1.7.0.67\bin
      driver = new ChromeDriver();
      //driver = new FirefoxDriver();
      driver.get("https://www.toolsqa.com/iframe-practice-page/");
      driver.manage().window().maximize();
      
  }

  @AfterMethod
  public void afterMethod() 
  {
	 // driver.quit();
	 
  }

}
