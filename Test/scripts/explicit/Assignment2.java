package scripts.explicit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Assignment2 
{
	WebDriver driver;
	WebDriverWait wait;
	  @Test
	  public void implictWait2() throws InterruptedException {
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
      driver.findElement(By.xpath("//div[@id='start']/button")).click();
    //  WebElement finish = driver.findElement(By.id("finish"));
      WebElement finish =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
      //WebElement finish = driver.findElement(By.xpath("finish"));
      
      String actualValue = finish.getText();     
      String expectedValue = "Hello World!";
      assertEquals(actualValue,expectedValue);
  }
  @BeforeMethod
  public void beforeMethod() {
        System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
        System.setProperty("webdriver.chrome.driver1", "test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
    //  driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
    //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        wait= new WebDriverWait(driver,30,250);
         
  }
 
  @AfterMethod
  public void afterMethod() 
  {
  }
 
}