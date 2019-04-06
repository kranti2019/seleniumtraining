//Goto http://toolsqa.com/automation-practice-form/, and do data entry - 
//   Put your name and surname and retrieve what you entered and print on console
//    Read the data typed in name and last name field by using 
//    getAttribute("value") methods
//    getText on text1 and text2
//    Enter other data including drop-down and multi-select

package scripts.assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Toolsqa 
{
	WebDriver driver;
  @Test
  public void Toolsqa() 
  {
	  String expectedTitle="Demo Form for practicing Selenium Automation";
		 String actualTitle=driver.getTitle();
		 if(expectedTitle.equals(actualTitle))
		 {
			 System.out.println("test case passed");
		 }
		 else
		 {
			 System.out.println("test case failed");
		 }

	    
    WebElement firstname=driver.findElement(By.name("firstname"));
    firstname.sendKeys("Kranti");
    System.out.println("First name is"+"-"+firstname.getAttribute("value"));
     
    WebElement lastname=driver.findElement(By.name("lastname"));
    lastname.sendKeys("Patil");
    System.out.println("Last name is"+"-"+lastname.getAttribute("value"));
     
    String Txt=driver.findElement(By.xpath("//span[@class='bcd']")).getText();
    System.out.println("text1 is"+"-"+Txt);
    
    String Txt1=driver.findElement(By.xpath("//label[@class='abc']")).getText();
    System.out.println("text2 is"+"-"+Txt1);
    
    //Select gender
    driver.findElement(By.xpath("//input[@value='Female']")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    //Select years of experience
    driver.findElement(By.xpath("//input[@value='7']")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    //Date    
    WebElement date1=driver.findElement(By.id("datepicker"));
    date1.sendKeys("03/03/2019");
    System.out.println("Date is"+"-"+date1.getAttribute("value"));
    //input[@id='datepicker']
    
    //Select optional feature
    WebElement tester = driver.findElement(By.id("profession-1"));
    tester.click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    WebElement tester1 = driver.findElement(By.id("profession-0"));
    tester1.click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    //Select automation tool   
    WebElement tool1 = driver.findElement(By.id("tool-1"));
    tool1.click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    WebElement tool2 = driver.findElement(By.id("tool-2"));
    tool2.click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    //Select dropdown
    Select contents= new Select(driver.findElement(By.id("continents")));
    assertEquals( contents.getOptions().size(),7);
    contents.selectByVisibleText("Australia");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //Selenium Commands
    WebElement commands = driver.findElement(By.name("selenium_commands"));
    Select command1 = new Select(commands);
    command1.selectByVisibleText("Navigation Commands");
    command1.selectByVisibleText("Switch Commands");
    command1.selectByVisibleText("Wait Commands");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    driver.findElement(By.name("submit")).click();
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  //System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
	  System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
	  //driver=new FirefoxDriver();
	   driver=new ChromeDriver();
	   driver.get("http://toolsqa.com/automation-practice-form/");
	   driver.manage().window().maximize();//to maximize the window 
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }

}
