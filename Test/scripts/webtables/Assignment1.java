
//http://the-internet.herokuapp.com/tables -
// Example 2 - Delete the row containing jdoe in Email Column.


package scripts.webtables;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.testng.annotations.AfterMethod;

public class Assignment1 {
	private WebDriver driver;
	private WebElement webTable;
	 private StringBuffer verificationErrors = new StringBuffer();
	 @Test
	 public void testWebTableTests1() {
	        try {
	             
	            
	            WebTable table = new WebTable(driver.findElement(By.cssSelector("div.example table[id='table1']")));
	     
	            //List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
	            table.getRowCount();
	            
	            System.out.println("Number of rows in the table "+table.getRowCount());
	            
	           table.getColumnCount();
	            
	           System.out.println("Number of columns in the table "+table.getColumnCount()+"..");
	            //Verify that specified value exists in second cell of third row
	          
	           table.deleteRow("Email", table.getCellData(4, 3));
	           
	           
	           assertEquals("jdoe@hotmail.com",table.getCellData(4, 3));
	           System.out.println("++++++"+table.getCellData(4, 3));
	           driver.findElement(By.xpath("(//a[@href='#delete'])[3]")).click();
	           
	          
	        } catch (Error e) {
	            //Capture and append Exceptions/Errors
	            verificationErrors.append(e.toString());
	        }
	    }
  
//	    Testclass1 table;
//	    table=new Testclass1(driver.findElement(By.id("table1")));
//		
//	    List<WebElement> tableRows=table.getAllDataRows();
//	    List<WebElement> tableCols=table.getAllDataRows();
//	    System.out.println("Number of rows in the table "+tableRows.size());
//	    System.out.println("Number of columns in the table "+tableCols.size());
//	    public boolean deleteRow(String columnHeader, String searchString)
//	    {
//	        List<WebElement> allRows = element.findElements(By.tagName("tr"));
//	        WebElement headerRow = allRows.get(0);
//	        List<WebElement> allHeaderColumns = headerRow.findElements(By.tagName("th"));
//	        int i = 0;
//	        int targetColumn = 0;
//	        for (WebElement oneHeaderCol : allHeaderColumns) {
//	            i++;
//	            if (oneHeaderCol.getText().contains(columnHeader)) {
//	                targetColumn = i;
//	                break;
//	            }
//	        }
//	    }
//  }
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
