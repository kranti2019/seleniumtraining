//Assignment1 (doubleClick)
//http://only-testing-blog.blogspot.in/2014/09/selectable.html
//- "Double click me to see alert" - double click
//- alert ok button click 

package scripts.actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class Assignment1 
{
	private WebDriver driver;
  @Test
  public void doubleclick() 
  {
	  driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
      WebElement doubleclick = driver.findElement(By.xpath("//button[contains(.,'Double-Click Me To See Alert')]"));
         		  
      Actions builder = new Actions(driver);
      builder.doubleClick(doubleclick);
      builder.perform();

      try {
           
          //Get the Alert
          Alert alert = driver.switchTo().alert();
           
          //Get the Text displayed on Alert using getText() method of Alert class
          String textOnAlert = alert.getText();
           
          //Click OK button, by calling accept() method of Alert Class
          alert.accept();
           
          //Verify Alert displayed correct message to user
          //AssertJUnit.assertEquals("Hello! I am an alert box!",textOnAlert);
           
      } catch (NoAlertPresentException e) 
      {
          e.printStackTrace();
      }
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
