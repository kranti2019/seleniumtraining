package scripts.webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Testclass1 
{
	private WebDriver driver;
	private WebElement element;
	public Testclass1(WebElement element)
	
 {
	      this.element=element;
	      
 }

    public List<WebElement> getAllDataRows() 
    {        
        return element.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));        
    }
 
    public int getRowCount()
    {
        List<WebElement> tableRows = element.findElements(By.tagName("tr"));
        return tableRows.size();
        
        
    }
    public int getColumnCount() {
        List<WebElement> tableRows = element.findElements(By.tagName("tr"));
        WebElement headerRow = tableRows.get(0);
        List<WebElement> tableCols = headerRow.findElements(By.tagName("td"));
        return tableCols.size();
    }
 
}