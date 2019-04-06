// Yahoo assignment, do the compose functionality and send an email to 
//  ketan@paratussystems.com, with subject " Hi Ketan, I am <your name>.
//  Body of the mail - "I have done my assignment."

package scripts.assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class GmailTest {
	WebDriver driver;
  @Test
  public void GmailTest() throws InterruptedException 
  {
	     WebElement username=driver.findElement(By.name("identifier"));
		 username.sendKeys("kranti.patil8@gmail.com");
		 driver.findElement(By.xpath("//content[contains(.,'Next')]")).click();
		Thread.sleep(5000);
		 driver.findElement(By.name("password")).sendKeys("kranti@2020");
		// name='password'
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
		 //driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click(); 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://mail.google.com/mail/u/0/?tab=km#inbox");
		 driver.findElement(By.xpath("//div[contains(@gh,'cm')]")).click();
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("ketan@paratussystems.com");
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(" Hi Ketan, I am Kranti");
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("I have done my assignment.");
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//div[@id=':qg']")).click();
		 //System.out.println(listOfElements);
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
  }

  @AfterClass
  public void afterClass()
  {
	 //driver.quit();
  }

}
