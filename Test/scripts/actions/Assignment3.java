//Assignment3(Most Important Assignment for entire training):
//- In triphobo.com implement the drag and drop automation
//- Click "Later" in be updated box
//- Houston in Texas
//- Click on button "Plan New Trip"
//- Click on "Save and Let me Plan" at the bottom of the screen
//- Click on "Skip to Plan" at the right hand top
//- Click on "Skip to Plan" again on the box
//- Click on "Add Activity"
//- Click on the Plus(+) sign when you hover mouse 
//  at the center of image of any attractions
//- Select "Day 2" 
//- Click on x for closing date screen
//- Click on X for closing activity screen
//- Drag the activity from day2 to day 3

package scripts.actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Assignment3 
{
	private WebDriver driver;
    WebDriverWait wait;
  @Test
  public void Assignment3()
  {
	  driver.get("http://triphobo.com/");
	 //- Click "Later" in be updated box
	  WebElement element = driver.findElement(By.xpath("//button[contains(.,'Later')]"));
	  element.click();
	  String parentWindowHandle = driver.getWindowHandle();
	 //- Houston in Texas
	  WebElement element1 = driver.findElement(By.xpath("//input[@type='search']"));
	  element1.sendKeys("Houston");
	  //Click on button "Plan New Trip"  
	  WebElement mo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='autosuggest-head head-item'][contains(.,'City')]")));
      Actions builder = new Actions(driver);
      builder.moveToElement(mo1).perform();
      //WebElement dept1 = driver.findElement(By.tagName("//i[contains(.,', Texas, United States, North America')]"));
      WebElement dept1 = driver.findElement(By.xpath("//i[contains(.,', Texas, United States, North America')]"));
      builder.moveToElement(dept1).click().perform();
      //- Click on "Save and Let me Plan" at the bottom of the screen
      driver.findElement(By.xpath("//a[contains(.,'Start Trip')]")).click();
      WebElement mo2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Save & Let me Plan')]")));
      mo2.click();
    //- Click on "Skip to Plan" again on the box
      WebElement mo3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Skip to plan')]")));
      mo3.click();
      WebElement mo4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Skip to Plan')]")));
      mo4.click();
    //- Click on "Add Activity"
      Set<String> allOpenWindowsByDriver = driver.getWindowHandles();
      System.out.println("No. Open Windows are - " + allOpenWindowsByDriver.size());
      WebElement mo5 = wait.until(ExpectedConditions.elementToBeClickable((By.id("close"))));
      mo5.click();
      WebElement mo6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add Activity']")));
      mo6.click();
      

    
      //- Click on the Plus(+) sign when you hover mouse 
       //  at the center of image of any attractions
      
      
      WebElement mo7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[contains(@class,'add-to-plan')])[4]")));
      Actions builder1 = new Actions(driver);
      builder1.moveToElement(mo7).click().perform();
//      WebElement dept2 = driver.findElement(By.xpath("((//i[contains(@class,'add-to-plan')])[4]"));
//      builder1.moveToElement(dept2).click().perform();
//      
      WebElement mo8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-day='3']")));
      Actions builder2 = new Actions(driver);
      builder2.moveToElement(mo7).click().perform();
//      builder1.moveToElement(mo7).perform();
//      WebElement dept3 = driver.findElement(By.xpath("(//i[@class='add-to-day-inst'][contains(.,'Click to add')])[2]"));
//      builder1.moveToElement(dept3).click().perform();
//      WebElement dept3 = driver.findElement(By.xpath("(//i[@class='add-to-plan'])[5]"));
//      builder2.moveToElement(dept2).click().perform();
     
     
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
