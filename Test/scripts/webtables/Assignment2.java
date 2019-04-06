//2. http://toolsqa.com/automation-practice-table/
//click on the "details" link on the row containing 2004 


package scripts.webtables;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Assignment2 
{
	private WebDriver driver;
  @Test
  public void assignment2()
  {
	  WebTable table = new WebTable(driver.findElement(By.cssSelector("div.content table")));
	     
     
      table.getRowCount();
      
      System.out.println("Number of rows in the table "+table.getRowCount());
      
     table.getColumnCount();
      
     System.out.println("Number of columns in the table "+table.getColumnCount()+"..");
     
     
     table.getCellData(5,4);
     
     assertEquals("2004",table.getCellData(5,4));
     System.out.println(table.getCellData(5,4)+"//table.getCellData(5,4)");
     
     driver.findElement(By.xpath("(//a[@href='#'][contains(.,'details')])[3]")).click();
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
      System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
      //driver = new FirefoxDriver();
      
      driver = new ChromeDriver();
      driver.get("http://toolsqa.com/automation-practice-table/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
  }

  @AfterMethod
  public void afterMethod()
  {
  }

}
