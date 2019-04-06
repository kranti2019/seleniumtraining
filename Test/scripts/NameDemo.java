package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NameDemo {

	public static void main(String[] args) {
		WebDriver driver;
		//System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver-64bit.exe");
		System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
		//driver=new FirefoxDriver();
			driver=new ChromeDriver();
		    driver.get("http://demo.guru99.com/test/ajax.html");
		    List<WebElement> elements = driver.findElements(By.name("name"));
		    System.out.println("Number of elements:" +elements.size());

		    for (int i=0; i<elements.size();i++){
		      System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
		    }
		  }
		}