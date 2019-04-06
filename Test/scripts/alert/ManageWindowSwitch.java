package scripts.alert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ManageWindowSwitch {
	 WebDriver driver;
	  @Test
	  public void manageAlerts() throws InterruptedException {
	        driver.get("http://selenium-examples.nichethyself.com/");
	        String expectedTitle = "STC Tourism";
	        String actualTitle = driver.getTitle();
	        String parentWindowHandle = driver.getWindowHandle();
	        assertEquals(actualTitle,expectedTitle);
	         
	        WebElement loginUserName = driver.findElement(By.id("loginname"));
	        loginUserName.sendKeys("stc123");
	         
	        driver.findElement(By.id("loginpassword")).sendKeys("12345");
	        driver.findElement(By.id("loginbutton")).click();
	         
	        driver.findElement(By.className("link")).click();
	         
	        try {
	            driver.switchTo().window("Contact");
	        }catch(NoSuchWindowException e){
	            fail("Contact Window was not present.");
	        }
	        //Thread.sleep(3000);
	        driver.findElement(By.className("glyphicon-search")).click();
	    //  driver.findElement(By.xpath("//a[@onclick='prompty()']")).click();
	        Thread.sleep(3000);
	        try {
	            Alert alert = driver.switchTo().alert();
	            alert.sendKeys("London");
	            Thread.sleep(3000);
	            alert.accept();
	        }catch (NoAlertPresentException e) {
	            fail("Alert not found.");
	        }
	         
	    //  driver.close();
	         
	        driver.switchTo().window(parentWindowHandle);
	         
	        driver.findElement(By.className("glyphicon-user")).click();
	        Thread.sleep(3000);
	         
	        driver.findElement(By.xpath("//button[text()='Write to us!']")).click();
	        Set<String> allOpenWindowsByDriver = driver.getWindowHandles();
	        System.out.println("No. Open Windows are - " + allOpenWindowsByDriver.size());
	         
	        for (String windowHandle: allOpenWindowsByDriver) {
	            if (!windowHandle.equals(parentWindowHandle)) {
	                driver.switchTo().window(windowHandle);
	                try {  
	                    driver.findElement(By.xpath("//button[text()='Submit']"));
	                    break;
	                }catch(NoSuchElementException e) {
	                     
	                }
	            }
	        }
	         
	        driver.findElement(By.name("name")).sendKeys("Paratus");
	        Thread.sleep(3000);
	         
	 
	  }
	  private void fail(String string) {
		// TODO Auto-generated method stub
		
	}
	@BeforeMethod
	  public void beforeMethod() {
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