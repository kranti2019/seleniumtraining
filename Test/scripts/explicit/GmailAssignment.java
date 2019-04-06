package scripts.explicit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class GmailAssignment 
{
	WebDriver driver;
    WebDriverWait wait;
  @Test
  public void f() throws InterruptedException 
  {
	    WebElement username=driver.findElement(By.name("identifier"));
	     username.sendKeys("kranti.patil8@gmail.com");
		 driver.findElement(By.xpath("//content[contains(.,'Next')]")).click();
		 
		 WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		 pwd.sendKeys("kranti@2020");
		 driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
		 
		 driver.get("https://mail.google.com/mail/u/0/?tab=km#inbox");
		 WebElement txt1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@gh,'cm')]")));
		 txt1.click();
		
		 WebElement txt2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
   	     txt2.sendKeys("kranti.patil8@gmail.com");
  	    
		 WebElement txt3=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@name='subjectbox']"))));
		 txt3.sendKeys(" Hi  I am Kranti");
//		
	
		 
		 driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("I have done my assignment.");
		 
		 WebElement txt4=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@aria-label='Send ‪(Ctrl-Enter)‬']"))));
		 txt4.click();
		 //driver.findElement(By.xpath("//div[@id=':qg']")).click();
				
		 driver.findElement(By.xpath("//span[contains(@class,'gb_ya gbii')]")).click();
		 driver.findElement(By.xpath("//a[contains(.,'Sign out')]")).click();
}
@BeforeClass
public void beforeClass() 
{
	//Prerequisite
		System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
		//System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
		driver=new FirefoxDriver();
	
		 //driver=new ChromeDriver();
		 driver.get("https://accounts.google.com/");
		 driver.manage().window().maximize();//to maximize the window
		 wait= new WebDriverWait(driver,30,250);
}

@AfterClass
public void afterClass()
{
	 //driver.quit();
}

}

