package scripts;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class GoogeleTest {
	WebDriver driver;
  @Test
  public void GoogleTest()
  {
	  List<WebElement> Googlelinks=driver.findElements(By.tagName("a"));
	//For loop
			for (int j = 0; j < Googlelinks.size(); j++) 
	        {
	            System.out.println(Googlelinks.get(j).getText()+" -  "+Googlelinks.get(j).getAttribute("href"));
	        }
			System.out.println("Size of elements"+ Googlelinks.size());
			//Enhanced for loop
			
		for (WebElement w1: Googlelinks) 
        {
			 
            System.out.println(w1.getText()+" -  "+w1.getAttribute("href"));
       }
		
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
		//System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
		driver=new FirefoxDriver();
	
		// driver=new ChromeDriver();
		 driver.get("https://www.google.com/");
		 driver.manage().window().maximize();//to maximize the window
  }

  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }

}

