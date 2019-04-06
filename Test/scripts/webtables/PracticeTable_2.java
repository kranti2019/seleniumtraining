package scripts.webtables;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class PracticeTable_2 
{
	private WebDriver driver;
  @Test
  public void  PracticeTable_2() throws InterruptedException 
  {
	  driver.get("http://toolsqa.com/automation-practice-table");
	  String sRow = "1";
	  String sCol = "2";
	  
	  //Here we are locating the xpath by passing variables in the xpath
	  String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
	  System.out.println(sCellValue);
	  String sRowValue = "Clock Tower Hotel";
	  Thread.sleep(10000);
	  //First loop will find the 'ClOCK TWER HOTEL' in the first column
	  for (int i=1;i<=5;i++){
	  String sValue = null;
	  sValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/th")).getText();
	  Thread.sleep(10000);
	  if(sValue.equalsIgnoreCase(sRowValue))
	  {
	  // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row 
	  for (int j=1;j<=5;j++){
	  String sColumnValue= driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText();
	  System.out.println(sColumnValue);
	  }
	  break;
	  }
	  }
	  driver.close();
	  }
	 
	  
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
      System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
      //driver = new FirefoxDriver();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
  }

  @AfterMethod
  public void afterMethod()
  {
  }

}