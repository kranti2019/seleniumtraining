
//http://the-internet.herokuapp.com/tables -
// Example 2 - Delete the row containing jdoe in Email Column.

package webtable;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import org.testng.annotations.Test;

import scripts.webtables.WebTable;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Assigment1 {
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
	
	public void clickDeleteBasedOffText() {
  		
  		Table= new WebTable(driver.findElement(By.id("table1")));
  		     
  		 	for(WebElement columns: Table.getAllDataRows())
  		 	{
  		    	if(columns.getText().contains("jdoe")) {
  		    		columns.findElement(By.xpath("//a[@href='#delete']")).click();	
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
	      driver.get("http://the-internet.herokuapp.com/tables");
	      driver.manage().window().maximize();
	  }

	  @AfterMethod
	  public void afterMethod() 
	  {
	  }

	}
