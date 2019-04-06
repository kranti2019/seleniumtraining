//2. http://toolsqa.com/automation-practice-table/
//click on the "details" link on the row containing 2004 

package webtable;

import org.testng.annotations.Test;

import scripts.webtables.WebTable;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Assignment2 {
	WebDriver driver;
	WebElement element;
	WebTable Table;  
	public void countRowsAndColumns() {
	  	driver.get("http://www.cookbook.seleniumacademy.com/Locators.html");
	  	
	  	//count columns 
	  	List <WebElement> countTotalColumns=driver.findElements(By.xpath("//table[@id='users']/thead/tr/td"));
		System.out.println(countTotalColumns.size());
		
		//count rows 
		List <WebElement> countTotalRows=driver.findElements(By.xpath("//table[@id='users']/tbody/tr"));
		System.out.println(countTotalRows.size());
	  	}
		
	
			
  @Test
  public void  Assignment2 () throws InterruptedException 
  {
	  WebTable table = new WebTable(driver.findElement(By.cssSelector("div.content table")));
	     
	  for(WebElement searchColumn: Table.getAllDataRows())
	  {
			if( searchColumn.getText().contains("2004")) 
			{
				
				Thread.sleep(3000);
				 
			//	searchColumn.findElement(By.xpath("(//a[@href='#'][contains(.,'details')])[3]")).click();
				
			searchColumn.findElement(By.xpath("//a[@href='#']")).click();
			}
		}  		
		  

		 
		 
		
	}
	
	/*
	@Test
public void f() {

		System.out.println("ALL THE BEST");

Table=new WebTable(driver.findElement(By.id("users")));
List<WebElement> allrows= Table.getAllDataRows();

int tablerow=2;

for(int i=1;i<= allrows.size();i++)
{
	  System.out.println(Table.getCellData(tablerow, 1)); 
	  
	  tablerow=tablerow+1;
	  
}

}
*/
	 @BeforeMethod
	  public void beforeMethod() 
	  {
		  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	      //driver = new FirefoxDriver();
	      driver = new ChromeDriver();
	      driver.get("http://toolsqa.com/automation-practice-table/");
	      driver.manage().window().maximize();
	  }

	  @AfterMethod
	  public void afterMethod() 
	  {
	  }

	}
