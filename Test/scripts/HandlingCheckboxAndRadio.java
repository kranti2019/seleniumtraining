package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class HandlingCheckboxAndRadio {
	 WebDriver driver;
	  @Test
	  public void handlingCheckboxAndRadioButton() throws InterruptedException {
	      driver.get("http://cookbook.seleniumacademy.com/Config.html");
	      WebElement airbags = driver.findElement(By.name("airbags"));
	      if (!airbags.isSelected())
	          airbags.click();
	      Thread.sleep(3000);
	       
	     // driver.findElement(By.xpath("//input[@value='Diesel']")).click();
	      driver.findElement(By.cssSelector("input[value='Diesel']")).click();
	      Thread.sleep(3000);
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
	  }
	 
	  @AfterMethod
	  public void afterMethod() {
	  }
	 
	}