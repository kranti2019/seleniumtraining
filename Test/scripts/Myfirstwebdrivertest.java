package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Myfirstwebdrivertest
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
		//System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
		driver=new FirefoxDriver();
	
		// driver=new ChromeDriver();
		 driver.get("http://selenium-examples.nichethyself.com/");
		 driver.manage().window().maximize();//to maximize the window
		 WebElement username=driver.findElement(By.id("loginname"));
		 username.sendKeys("stc123");
		 driver.findElement(By.id("loginpassword")).sendKeys("12345");
		 driver.findElement(By.id("loginbutton")).click();
		 String expectedTitle="My account";
		 String actualTitle=driver.getTitle();
		 if(expectedTitle.equals(actualTitle))
		 {
			 System.out.println("Login test case passed");
		 }
		 else
		 {
			 System.out.println("Login test case failed");
		 }
				 
	}

}
