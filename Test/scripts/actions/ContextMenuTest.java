package scripts.actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ContextMenuTest {
	WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
         
    /*  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    */  
         driver.get("http://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
    }
     
    @Test
    public void testContextMenu() {
      WebElement clickMeElement = 
              driver.findElement(By.cssSelector(".context-menu-one.btn.btn-neutral"));
      WebElement editMenuItem = 
              driver.findElement(By.cssSelector("li.context-menu-item.icon-edit"));
       
      Actions builder = new Actions(driver);
      builder.contextClick(clickMeElement)
        .moveToElement(editMenuItem)
        .click()
        .perform();
       
      WebDriverWait wait = new WebDriverWait(driver, 10);
       
      Alert alert = wait.until(ExpectedConditions.alertIsPresent());
      assertEquals("clicked: edit", alert.getText());
      alert.dismiss();
    }
 
    @Test
    public void testContextMenuWithKeys() {
      WebElement clickMeElement = 
              driver.findElement(By.cssSelector("div.context-menu-one.box.menu-1"));
       
      Actions builder = new Actions(driver);
      builder.contextClick(clickMeElement)
        .sendKeys(Keys.chord(Keys.ALT, "e"))
        .perform();
       
      WebDriverWait wait = new WebDriverWait(driver, 10);
       
      Alert alert = wait.until(ExpectedConditions.alertIsPresent());
      assertEquals("clicked: edit", alert.getText());
      alert.dismiss();
    }
 
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}