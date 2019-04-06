package script.ddt.excel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class GmailLoginTest {
	 WebDriver driver;
	 ReadGmailExcel rd;
	 WebDriverWait wait;
	    @Test(dataProvider ="GmailLoginData")
	    public void LoginTest(String user, String pass) 
	    {
	  	  WebElement username=driver.findElement(By.name("identifier"));
	  	     username.sendKeys(user);
	  		 driver.findElement(By.xpath("//content[contains(.,'Next')]")).click();
	  		 
	  		 WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	  		 pwd.sendKeys(pass);
	  		 driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
	    }
	    @BeforeMethod
	    public void beforeMethod() 
	    {
	  	  //Prerequisite
	  		System.setProperty("webdriver.gecko.driver", "Test\\resources\\data\\geckodriver-64bit.exe");
	  		//System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
	  		driver=new FirefoxDriver();
	  	
	  		 //driver=new ChromeDriver();
	  		 driver.get("https://accounts.google.com/");
	  		 driver.manage().window().maximize();//to maximize the window
	  		 wait= new WebDriverWait(driver,30,250);
	    }

	    @AfterMethod
	    public void afterMethod()
	    {
	  	  driver.quit();
	    }

	 
	  @DataProvider (name="GmailLoginData")
	  public Object[][] getLoginData()
	  {
	      String[][] GmailLoginData=rd.getDataFromXLSUsingJXL("Test//resources//data//Gmaillogin.xls",
	    		  "LoginData", "StartAndEnd");
	        return GmailLoginData;    
	  }
}