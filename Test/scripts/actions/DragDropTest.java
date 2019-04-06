package scripts.actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

public class DragDropTest {
	 private WebDriver driver;
	    private StringBuffer verificationErrors = new StringBuffer();
	     
	    @BeforeMethod
	    public void setUp()
	    {
	    	System.setProperty("webdriver.chrome.driver", "test\\resources\\Chromedriver.exe");
	        //path = c:\program files\java\jdk1.7.0.67\bin
	        driver = new ChromeDriver();
	         
	    /*  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
	        driver = new FirefoxDriver();*/
	         
	         
	    }
	 
	    @Test
	    public void testDragDrop() {
	         
	        driver.get("http://www.cookbook.seleniumacademy.com/DragDropDemo.html");
	         
	        WebElement source = driver.findElement(By.id("draggable"));
	        WebElement target = driver.findElement(By.id("droppable"));
	    //  System.out.println(target.getText());
	        Actions builder = new Actions(driver);//Builder design Pattern
	        builder.dragAndDrop(source, target).perform();
	/*      builder.moveToElement(source).perform();//mouse hover
	        builder.contextClick(source).build().perform();
	        builder.dragAndDrop(source, target)
	               .moveToElement(source)
	               .contextClick(source)
	               .click()
	               .sendKeys("niche").build();
	        builder.perform();
	        builder.perform();
	                
	         
	        if () 
	             builder.doubleClick().build();
	        else
	            builder.click().build();
	        builder.perform();
	*/     
	        //builder.
	         
	        try
	        {
	            System.out.println(target.getText());
	            AssertJUnit.assertEquals("Dropped!", target.getText());
	        } catch (Error e) {
	            verificationErrors.append(e.toString());
	        }
	    }
	     
	    @AfterMethod
	    public void tearDown()
	    {
	    //  driver.quit();
	        String verificationErrorString = verificationErrors.toString();
	        if (!"".equals(verificationErrorString)) {
	            Assert.fail(verificationErrorString);
	        }
	    }
	}
