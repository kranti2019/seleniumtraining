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
import org.testng.annotations.AfterMethod;

public class HandlingAlerts 
{
	WebDriver driver;
  @Test
  public void HandlingAlerts() throws InterruptedException 
  {
	  driver.get("http://selenium-examples.nichethyself.com/");
      WebElement username = driver.findElement(By.id("loginname"));
      username.sendKeys("stc123");
      driver.findElement(By.id("loginbutton")).click();
      Thread.sleep(3000);
      Alert myAlert;
       
      try
      {
          myAlert = driver.switchTo().alert();
          assertEquals(myAlert.getText(),"Please enter Password");
          myAlert.accept();
      }
      catch(NoAlertPresentException e) 
      {
          fail("Fail the test as alert did not appear.");
      }
      driver.findElement(By.id("loginpassword")).sendKeys("12345");
      driver.findElement(By.id("loginbutton")).click();
      driver.findElement(By.id("logo")).click();
      Thread.sleep(3000);
      
      try 
      {
          myAlert = driver.switchTo().alert();
          assertEquals(myAlert.getText(),"Do you wanna leave the page?");
          myAlert.dismiss();
          Thread.sleep(3000);
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