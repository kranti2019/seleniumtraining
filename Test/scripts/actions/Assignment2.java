//Assignment2 (In WebDriver - moveToElement)
//- Anna assignment
//1. goto http://annauniv.edu/
//2. click on "Departments" link
//3. Goto "Faculty Of Civil Engineering" and click on "Institute for Ocean Management"
//4. Verify the page title.
//5. Goto "Research Themes" options and Click "Coastal Pollution Monitoring and Hazards"
//6. Verify the page title.

package scripts.actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Assignment2 
{
	private WebDriver driver;
	WebDriverWait wait;
  @Test
  public void movetoelement() 
{
      driver.get("http://annauniv.edu/");
      WebElement dept = driver.findElement(By.linkText("Departments"));
      dept.click();
	  WebElement mo1 = driver.findElement(By.xpath("//strong[contains(.,'Faculty of Civil Engineering')]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(mo1).perform();
      WebElement dept1 = driver.findElement(By.id("menuItemHilite32"));
      builder.moveToElement(dept1).click().perform();
      String expected="Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts";
      assertEquals(driver.getTitle(),expected);
     //mo1.click();
      WebElement mo2 = driver.findElement(By.xpath("//td[@width='8%'][contains(.,'Research Themes')]"));
      Actions builder1 = new Actions(driver);
      builder1.moveToElement(mo2).perform();
      WebElement dept2 = driver.findElement(By.id("menuItemHilite13"));
      builder.moveToElement(dept2).click().perform();
      String expected1="404 Not Found";
      assertEquals(driver.getTitle(),expected1);
 
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
      driver = new ChromeDriver();
	  
      driver.manage().window().maximize();
      //wait= new WebDriverWait(driver,30);
  }

  @AfterMethod
  public void afterMethod()
  {
  }

}
