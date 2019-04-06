package scripts.log4j;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class NewTest3 {
	private WebDriver driver;
	private Logger logger;
	WebDriverWait wait;
  @Test
  public void f() 
  {
	  // Here we need to create logger instance so we need to pass Class name for 
	     //which  we want to create log file in my case Google is classname
	         logger=Logger.getLogger("Google");
	        
	 
	       // configure log4j properties file
	      PropertyConfigurator.configure("log4j.properties");
	         
	         //DOMConfigurator.configure("log4j.xml");
	       // Set implicit wait
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        logger.info("Implicit wait given");
	      
	 
	        // Load application
	        driver.get("https://www.google.co.in/");
	        logger.info("Url opened");
	      
	 
	        // type Selenium
	        driver.findElement(By.name("q")).sendKeys("Selenium");
	        logger.info("keyword type");  
	 
  }
  @BeforeMethod
  public void beforeMethod() {
	 
	 
	        // Open browser
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      wait= new WebDriverWait(driver,60,250);
	        //logger.info("Browser Opened");
	      
	                
  }

  @AfterMethod
  public void afterMethod() {
  }

}
