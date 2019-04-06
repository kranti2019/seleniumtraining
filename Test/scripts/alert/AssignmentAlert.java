//Go to https://the-internet.herokuapp.com/javascript_alerts
//  1. "Click for JS Alert" - click on this option, handle the alert, 
//      read the message and verify. Also verify the text displayed under Result is 
//      "You successfuly clicked an alert" and it is in green color.
//      Repeat same for other two buttons having different alerts

package scripts.alert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AssignmentAlert 
{
	WebDriver driver;
  @Test
  public void test1() throws InterruptedException 
  {
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	  Alert myAlert;
      
      try
      {
          myAlert = driver.switchTo().alert();
          System.out.println(myAlert.getText());
          assertEquals(myAlert.getText(),"I am a JS Alert");
          Thread.sleep(3000);
          myAlert.accept();
          WebElement element = driver.findElement(By.xpath("//p[@id='result']"));
          element.getCssValue("p[style]");
          String actualText = element.getText();
          System.out.println(actualText);
          String expectedText="You successfuly clicked an alert";
          Assert.assertEquals(expectedText, actualText);
      }
      catch(NoAlertPresentException e) 
      {
          fail("Fail the test as alert did not appear.");
      }
      
  ///////////////////////////////////////////////////////////////////////////////////    
      
      driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
	        
      try
      {
          myAlert = driver.switchTo().alert();
          System.out.println(myAlert.getText());
          assertEquals(myAlert.getText(),"I am a JS Confirm");
          Thread.sleep(3000);
          myAlert.accept();
          WebElement element = driver.findElement(By.xpath("//p[@id='result']"));
          element.getCssValue("p[style]");
          String actualText = element.getText();
          System.out.println(actualText);
          String expectedText="You clicked: Ok";
          Assert.assertEquals(expectedText, actualText);
      }
      catch(NoAlertPresentException e) 
      {
          fail("Fail the test as alert did not appear.");
      }
      
     
    //cancel button
      driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
      
      try
      {
          myAlert = driver.switchTo().alert();
          System.out.println(myAlert.getText());
          assertEquals(myAlert.getText(),"I am a JS Confirm");
          Thread.sleep(3000);
          myAlert.dismiss();
          WebElement element = driver.findElement(By.xpath("//p[@id='result']"));
          element.getCssValue("p[style]");
          String actualText = element.getText();
          System.out.println(actualText);
          String expectedText="You clicked: Cancel";
          Assert.assertEquals(expectedText, actualText);
      }
      catch(NoAlertPresentException e) 
      {
          fail("Fail the test as alert did not appear.");
      }
      
 /////////////////////////////////////////////////////////////////////////////////////
      driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
      
      try
      {
          myAlert = driver.switchTo().alert();
          System.out.println(myAlert.getText());
          assertEquals(myAlert.getText(),"I am a JS prompt");
          Thread.sleep(3000);
          myAlert.sendKeys("kranti");
          myAlert.accept();
         
          WebElement element = driver.findElement(By.xpath("//p[@id='result']"));
          element.getCssValue("p[style]");
          String actualText = element.getText();
          System.out.println(actualText);
          String expectedText="You entered: kranti";
          Assert.assertEquals(expectedText, actualText);
      }
      catch(NoAlertPresentException e) 
      {
          fail("Fail the test as alert did not appear.");
      }
      
    //cancel button
      driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
      
      try
      {
          myAlert = driver.switchTo().alert();
          System.out.println(myAlert.getText());
          assertEquals(myAlert.getText(),"I am a JS prompt");
          Thread.sleep(3000);
         
          myAlert.dismiss();
         
          WebElement element = driver.findElement(By.xpath("//p[@id='result']"));
          element.getCssValue("p[style]");
          String actualText = element.getText();
          System.out.println(actualText);
          String expectedText="You entered: null";
          Assert.assertEquals(expectedText, actualText);
      }
      catch(NoAlertPresentException e) 
      {
          fail("Fail the test as alert did not appear.");
      }
          
      
      
      }
     
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
      System.setProperty("webdriver.chrome.driver1", "test\\resources\\chromedriver.exe");
      System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
      driver = new FirefoxDriver();
      //driver = new ChromeDriver();
  //  driver = new InternetExplorerDriver();
      driver.manage().window().maximize();

  }
  
  @AfterMethod
  public void afterMethod() 
  {
  }

}
