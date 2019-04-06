package scripts.actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class ContextClick {
	private WebDriver driver;
	 
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
      driver = new ChromeDriver();
//        System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
    //    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
 
    @Test
    public void contextClick() {
         driver.get("http://the-internet.herokuapp.com/context_menu");
         WebElement contextArea = driver.findElement(By.id("hot-spot"));
         Actions builder = new Actions(driver);
         builder.contextClick(contextArea).
         sendKeys(Keys.ARROW_DOWN).
          //sendKeys(Keys.ARROW_DOWN).
        // sendKeys(Keys.RETURN).
         build().perform();
          
            try {
                 
                //Get the Alert
                Alert alert = driver.switchTo().alert();
                 
                //Get the Text displayed on Alert using getText() method of Alert class
                String textOnAlert = alert.getText();
                 
                //Click OK button, by calling accept() method of Alert Class
                alert.accept();
                 
                //Verify Alert displayed correct message to user
                //AssertJUnit.assertEquals("Hello! I am an alert box!",textOnAlert);
                 
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            //  fail("Don't know what developer has done");
            }
         
    }
 
    @AfterMethod
    public void tearDown() {
    
    }
}
