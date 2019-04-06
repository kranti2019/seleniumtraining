package script.ddt.excel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class CSVTest {
	WebDriver driver;
	 
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
	    public void beforeMethod() throws InterruptedException 
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

	    @AfterMethod
	    public void afterMethod()
	    {
	  	  driver.quit();
	    }

	    
	    
	    @DataProvider (name = "GmailLoginData") 
	    public Iterator getDataFromCSV()
	    {
	          Collection<String[]> retObjArr=null;
	        try 
	        {
	            retObjArr = getTestData("Test\\resources\\Datacsv.csv");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	            return(retObjArr.iterator());     
	 
	    }
	    public static Collection<String[]> getTestData(String fileName) throws IOException {
            List<String[]> records = new ArrayList<String[]>();
            String record;
 
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            while ((record=file.readLine())!=null) {//record = "168,70,24.8,Normal"
                String fields[] = record.split(",");//split() method is inside String class
                records.add(fields);
            }
            file.close();
            return records;
        }
       
		   
}
	 
