package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class SelectElementExamples {
	  WebDriver driver;
	  //@Test
	  public void dropDownTest() throws InterruptedException {
	      driver.get("http://selenium-examples.nichethyself.com/home.html");
	      driver.findElement(By.linkText("Customized tours")).click();
	      Select preferredStay = new Select(driver.findElement(By.id("days")));
	      assertEquals(preferredStay.getOptions().size(),3);
	      List<String> expectedOptions = new ArrayList();
	      List<String> actualOptions = new ArrayList();
	      expectedOptions.add("5-star Hotel");
	      expectedOptions.add("3-star Hotel");
	      expectedOptions.add("Home Stay");
	       
	      for (WebElement oneOption: preferredStay.getOptions()) {
	          actualOptions.add(oneOption.getText());
	      }
	       
	      assertEquals(actualOptions,expectedOptions);
	      preferredStay.selectByVisibleText("Home Stay");
	      //preferredStay.selectByValue("");
	      preferredStay.selectByIndex(1);
	      WebElement currentSelection = preferredStay.getFirstSelectedOption();
	      assertEquals(currentSelection.getText(),"3-star Hotel");
	      Thread.sleep(3000);
	  }
	   
	  @Test
	  public void multiSelectTest() throws InterruptedException {
	      driver.get("http://cookbook.seleniumacademy.com/Config.html");
	      WebElement colorSelection = driver.findElement(By.name("color"));
	      Select color = new Select(colorSelection);
	      color.selectByValue("bl");
	      color.selectByVisibleText("Red");
	      color.selectByIndex(3);
	       
	      assertEquals(color.getAllSelectedOptions().size(),3);
	      List<String> expectedOptions = new ArrayList();
	      List<String> actualOptions = new ArrayList();
	      expectedOptions.add("Black");
	      expectedOptions.add("Red");
	      expectedOptions.add("Brown");
	      Thread.sleep(3000);
	      for (WebElement oneOption: color.getAllSelectedOptions()) {
	          actualOptions.add(oneOption.getText());
	      }
	       
	      assertEquals(actualOptions,expectedOptions);
	       
	      color.deselectByValue("rd");
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