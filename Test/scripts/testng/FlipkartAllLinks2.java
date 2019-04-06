//Goto flipkart.com and print all the link elements on flipkart home page.
package scripts.testng;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class FlipkartAllLinks2 
{
	WebDriver driver;
  @Test
  public void flipkartlinks() 
  {
	  List<WebElement> flipkartlinks=driver.findElements(By.tagName("a"));
		//For loop
				
	  for (int j = 0; j < flipkartlinks.size(); j++) 
		        
	  {
	  System.out.println(flipkartlinks.get(j).getText()+" -  "+flipkartlinks.get(j).getAttribute("href"));
		        
	  }
				
	  System.out.println("Size of elements"+"-"+ flipkartlinks.size());
				//Enhanced for loop
//				
//	  for (WebElement flinks: flipkartlinks) 
//	   {
//				 
//	    System.out.println(flinks.getText()+" -  "+flinks.getAttribute("href"));
//	   }
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  //System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
	  System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
	  //driver=new FirefoxDriver();
	   driver=new ChromeDriver();
	   driver.get("https://www.flipkart.com/");
	   driver.manage().window().maximize();//to maximize the window  
  }

  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
	  
  }

}
