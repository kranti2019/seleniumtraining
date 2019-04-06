// 2. go to http://www.cookbook.seleniumacademy.com/Alerts.html 
// and handle all the three alerts and verify the messages on the home page. 

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

public class AssignmentAlert1 
{
	WebDriver driver;
  @Test
  public void AssignmentAlert1() throws InterruptedException 
  {
	  driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html ");
	  
	  driver.findElement(By.xpath("//input[@id='simple']")).click();
	  Alert myAlert;
	  try
      {
          myAlert = driver.switchTo().alert();
          System.out.println(myAlert.getText());
          assertEquals(myAlert.getText(),"Hello! I am an alert box!");
          Thread.sleep(3000);
          myAlert.accept();
         
      }
      catch(NoAlertPresentException e) 
      {
          fail("Fail the test as alert did not appear.");
      }
	  //////////////////////////////////////////////////////////////////////////
	  driver.findElement(By.xpath("//button[@id='confirm']")).click();
      
      try
      {
          myAlert = driver.switchTo().alert();
          System.out.println(myAlert.getText());
          assertEquals(myAlert.getText(),"Press a button!");
          Thread.sleep(3000);
          myAlert.accept();
          WebElement element = driver.findElement(By.xpath("//p[@id='demo']"));
          element.getCssValue("p[id]");
          String actualText = element.getText();
          System.out.println(actualText);
          String expectedText="You Accepted Alert!";
          Assert.assertEquals(expectedText, actualText);
      }
      catch(NoAlertPresentException e) 
      {
          fail("Fail the test as alert did not appear.");
      }
      
     
    //cancel button
      driver.findElement(By.xpath("//button[@id='confirm']")).click();
      
      try
      {
          myAlert = driver.switchTo().alert();
          System.out.println(myAlert.getText());
          assertEquals(myAlert.getText(),"Press a button!");
          Thread.sleep(3000);
          myAlert.dismiss();
          WebElement element = driver.findElement(By.xpath("//p[@id='demo']"));
          element.getCssValue("p[id]");
          String actualText = element.getText();
          System.out.println(actualText);
          String expectedText="You Dismissed Alert!";
          Assert.assertEquals(expectedText, actualText);
      }
      catch(NoAlertPresentException e) 
      {
          fail("Fail the test as alert did not appear.");
      }
  /////////////////////////////////////////////////////////////////////////////////
    driver.findElement(By.xpath("//button[@id='prompt']")).click();
      
      try
      {
          myAlert = driver.switchTo().alert();
          System.out.println(myAlert.getText());
          assertEquals(myAlert.getText(),"Please enter your name");
          Thread.sleep(3000);
          myAlert.sendKeys("kranti");
          myAlert.accept();
         
          WebElement element = driver.findElement(By.xpath("//p[@id='prompt_demo']"));
          element.getCssValue("p[id]");
          String actualText = element.getText();
          System.out.println(actualText);
          String expectedText="Hello kranti! How are you today?";
          Assert.assertEquals(expectedText, actualText);
      }
      catch(NoAlertPresentException e) 
      {
          fail("Fail the test as alert did not appear.");
      }
      
    //cancel button
      driver.findElement(By.xpath("//button[@id='prompt']")).click();
      
      try
      {
          myAlert = driver.switchTo().alert();
          System.out.println(myAlert.getText());
          assertEquals(myAlert.getText(),"Please enter your name");
          Thread.sleep(3000);
          
         
          myAlert.dismiss();
         
          WebElement element = driver.findElement(By.xpath("//p[@id='prompt_demo']"));
          element.getCssValue("p[id]");
          String actualText = element.getText();
          System.out.println(actualText);
          String expectedText="Hello kranti! How are you today?";
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
	  driver.close();
  }

}
