package scripts.actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

public class RowSelectionTests {
	 WebDriver driver;
     
	 
	    @BeforeMethod
	    public void setUp()
	    {
	        System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	        driver = new ChromeDriver();
	        /*System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
	        driver = new FirefoxDriver();*/
	        driver.get("http://component-showcase.icesoft.org/component-showcase/showcase.iface");
	        driver.findElement(By.linkText("Table")).click();
	        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	        WebDriverWait wait = new WebDriverWait(driver,30);
	        WebElement rowSelection = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Row Selection")));
	    //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        rowSelection.click();
	        //driver.findElement(By.linkText("Row Selection")).click();
	        //assignment - find alternate locator for 'multiple' radio button
	        WebElement selectMultiple = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='iceSelOneRb']/tbody/tr/td[2]/label")));
	        selectMultiple.click();
	        //driver.findElement(By.xpath("//table[@class='iceSelOneRb']/tbody/tr/td[2]/label")).click();
	    }
	 
	    @Test
	    public void testRowSelectionUsingControlKey() {
	         
	        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='iceDatTbl']/tbody/tr"));
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }       
	        //Select second and fourth row from Table using Control Key.
	        //Row Index start at 0
	        Actions builder = new Actions(driver); //builder design pattern
	        //builder design pattern
	        builder.click(tableRows.get(1)).keyDown(Keys.CONTROL).click(tableRows.get(3)).click(tableRows.get(5)).keyUp(Keys.CONTROL).build();//
	        builder.perform();//Actual action happens on the page
	    //  builder.keyDown(Keys.SHIFT).click(tableRows.get(7)).keyUp(Keys.SHIFT).build().perform();;
	        //builder.perform();
	         
	        //Verify Selected Row Table shows two rows selected 
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"));
	        AssertJUnit.assertEquals(3,rows.size());
	         
	    //  WebElement someElement = driver.findElement(By.name("ome"));
	     
	    }
	     
	    @Test
	    public void testRowSelectionUsingShiftKey() throws InterruptedException {
	         
	        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='iceDatTbl']/tbody/tr"));
	 
	        //Select first row to fourth row from Table using Shift Key
	        //Row Index start at 0
	        Actions builder = new Actions(driver);
	        builder.click(tableRows.get(0)).keyDown(Keys.SHIFT)
	                .click(tableRows.get(1))
	                .click(tableRows.get(2))
	                .click(tableRows.get(3))
	                .keyUp(Keys.SHIFT)
	                .build().perform();
	        Thread.sleep(10000);
	        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"));
	        AssertJUnit.assertEquals(4,rows.size());
	    }
	     
	    @AfterMethod
	    public void tearDown()
	    {
	        //driver.quit();
	    }
	 
	}