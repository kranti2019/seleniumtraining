package script.ddt.excel;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import scripts.poi.excel.ReadLoginTest;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class AssignmentTest {
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

	 
	  @DataProvider (name="GmailLoginData")
	  public Object[][] getLoginData()
	  {
		  Object[][] LoginData=getDataFromXLSUsingJXL("Test\\resources\\Gmaillogin.xls",
	    		  "LoginData", "StartAndEnd");
	        return LoginData;    
	  }
	  public static String[][] getDataFromXLSUsingJXL(String xlFilePath,String sheetName, String tableName)
	  {
		  
			 String[][] tabArray=null;
			      try{
			          Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			          //Workbook class is provied by jxl.jar
			          //WebDriver provided by Selenium 
			          //File is class provided by Java to read a physical file
			          Sheet sheet = workbook.getSheet(sheetName);
			          Cell tableStart=sheet.findCell(tableName);
			           
			          int startRow,startCol, endRow, endCol,ci,cj;
			           
			          startRow=tableStart.getRow();//2
			          startCol=tableStart.getColumn();//1
			 
			          //Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);   
			          Cell tableEnd= sheet.findCell(tableName);
			 
			          endRow=tableEnd.getRow();//6
			          endCol=tableEnd.getColumn();//4
			          System.out.println("startRow="+startRow+", endRow="+endRow+", " +
			                  "startCol="+startCol+", endCol="+endCol);
			          tabArray=new String[endRow-startRow-1][endCol-startCol-1];//5,4
			          ci=0; //array row
			          //ci=0,i=3, j=3,cj=1
			          for (int i=startRow+1;i<endRow;i++,ci++){//i represents xls row
			              cj=0;//array column
			              for (int j=startCol+1;j<endCol;j++,cj++){//j represents xls column
			                  tabArray[ci][cj]=sheet.getCell(j,i).getContents();
			              }
			          }
			      }
			      catch (Exception e)    {
			          System.out.println("Please check if file path, sheet name and tag name are correct");
			           
			      }
			 
			      return(tabArray);
			  }

			  
}