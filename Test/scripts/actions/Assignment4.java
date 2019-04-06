//Assignment2
//go to http://cookbook.seleniumacademy.com/Config.html/ and try to switch 
//between multiple windows ("Help", "Online Chat Support" and "Visit US")


package scripts.actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Assignment4 {
	WebDriver driver;
  @Test
  public void Windowhandling1() throws InterruptedException 
  {
	  driver.get("http://cookbook.seleniumacademy.com/");
	  driver.findElement(By.xpath("//a[contains(.,'Build My Car Application')]")).click();
	  
        String parentWindowHandle = driver.getWindowHandle();
       
	    System.out.println(parentWindowHandle);
	  driver.findElement(By.xpath("//button[contains(.,'Help')]")).click();
	  
	   
       try {
           driver.switchTo().window("HelpWindow");
           
	   
          
            }catch(NoSuchWindowException e){
           fail("HelpWindow was not present.");
       }
       driver.close();
       
       driver.switchTo().window(parentWindowHandle);
       
       
        driver.findElement(By.xpath("//button[contains(.,'Visit Us')]")).click();
	  	   
       try {
           driver.switchTo().window("VisitUsWindow");
           
	   
          
            }catch(NoSuchWindowException e){
           fail("VisitUsWindow was not present.");
       }
       driver.close();
       
       driver.switchTo().window(parentWindowHandle);
       
       
       
       driver.findElement(By.xpath("//button[contains(.,'Online Chat Support')]")).click();
       Set<String> allOpenWindowsByDriver = driver.getWindowHandles();
       System.out.println("No. Open Windows are - " + allOpenWindowsByDriver.size());
       for (String windowHandle: allOpenWindowsByDriver) 
       {
    	   System.out.println(windowHandle);
           if (!windowHandle.equals(parentWindowHandle))
           {
               driver.switchTo().window(windowHandle);
               try {  
            	   String abc=driver.getTitle();
            	  System.out.println(abc);
                   
                   break;
               }catch(NoSuchElementException e) {
                    
               }
               
               driver.findElement(By.xpath("//input[@type='Submit']")).click();
           }
       }
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
      System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
      //driver = new FirefoxDriver();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);         

  }

  @AfterMethod
  public void afterMethod() {
  }

}
