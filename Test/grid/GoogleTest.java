package grid;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class GoogleTest {
	RemoteWebDriver driver;
  @Test
  public void GoogleTest() throws InterruptedException
  {
	  driver.get("https://www.google.com/");
	  Thread.sleep(2000);
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
//	  System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
//		//System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
//		driver=new FirefoxDriver();
	
		// driver=new ChromeDriver();
	  DesiredCapabilities capabilities=new  DesiredCapabilities();
	  capabilities.setBrowserName("firefox");
	  try {
		driver=new RemoteWebDriver(new URL("http://192.168.0.130:4444/wd/hub"), capabilities);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		 driver.manage().window().maximize();//to maximize the window
  }

  @AfterMethod
  public void afterMethod()
  {
	 // driver.quit();
  }

}

