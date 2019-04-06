package scripts.webtables;

import org.testng.annotations.Test;



import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class HandleWebTables {
  WebDriver driver;	
  WebTable table;
  //ExplicitWait wait;
	
  	//@Test
  	public void countRowsAndColumns() {
  	driver.get("http://www.cookbook.seleniumacademy.com/Locators.html");
  	
  	//count columns 
  	List <WebElement> countTotalColumns=driver.findElements(By.xpath("//table[@id='users']/thead/tr/td"));
	System.out.println(countTotalColumns.size());
	
	//count rows 
	List <WebElement> countTotalRows=driver.findElements(By.xpath("//table[@id='users']/tbody/tr"));
	System.out.println(countTotalRows.size());
  	}
	
    //table = new WebTable(driver.findElement(By.id("users")));
	
  		
  	@Test
  	public void clickDeleteBasedOffText() {
  		driver.get("http://the-internet.herokuapp.com/tables");
  		table= new WebTable(driver.findElement(By.id("table1")));
  		     
  		 	for(WebElement columns: table.getAllDataRows()){
  		    	if(columns.getText().contains("jdoe")) {
  		    		columns.findElement(By.xpath("//a[@href='#delete']")).click();	
  		    	}
  		 	}
  		}
  		
  	@Test
  	public void clickDetailsBasedOFFText() throws InterruptedException {
  		driver.get("https://www.toolsqa.com/automation-practice-table");
  		//wait = new ExplicitWait(driver.findElement(By.tagName("h1")),this.driver);
 
  		table = new WebTable(driver.findElement(By.cssSelector("table[class='tsc_table_s13']")));
  		for(WebElement toolsQAColumn: table.getAllDataRows())
  		{
  			if(toolsQAColumn.getText().contains("2004")) 
  			{
  				
  				Thread.sleep(3000);
  				toolsQAColumn.findElement(By.cssSelector("a[href='#']")).click();
  			}
  		}  		
  		
  	}
  
  	@BeforeMethod
  	public void beforeMethod() {
  		 System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	
  }

  
  @AfterMethod
  public void tearDown() {
	  //driver.quit();
	  
  }

}
