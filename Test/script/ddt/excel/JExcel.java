package script.ddt.excel;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import script.ddt.excel.ReadGmailExcel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class JExcel {
	 WebDriver driver;
	 
	 WebDriverWait wait;
	    @Test(dataProvider ="GmailLoginData1")
	    public void LoginTest(String user, String pass) throws InterruptedException 
	    {
	  	  WebElement username=driver.findElement(By.name("identifier"));
	  	     username.sendKeys(user);
	  		 driver.findElement(By.xpath("//content[contains(.,'Next')]")).click();
	  		 Thread.sleep(10000);
	  		 WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	  		 pwd.sendKeys(pass);
	  		 Thread.sleep(10000);
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

	 
	  @DataProvider (name="GmailLoginData1")
	  public static Object[][] getLoginData() 
	  {
		  String[][] LoginData=getDataFromXLSUsingJXL("E:\\Test.xls", "LoginData1", "StartAndEnd");
	        return LoginData;
	  }
	  
	  public static String[][] getDataFromXLSUsingJXL(String xlFilePath,String sheetName, String tableName)
	  {
		  
		  System.out.println(xlFilePath+";;;;"+sheetName+tableName);
			 String[][] tabArray=null;
			      try{
			          Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			          //Workbook class is provied by jxl.jar
			          //WebDriver provided by Selenium 
			          //File is class provided by Java to read a physical file
			          System.out.println("ppppppppp");
			          Sheet sheet = workbook.getSheet(sheetName);
			          System.out.println(sheet.getName()+"hhhhhhhhhhhhhhhhhhh"+sheet.getRows()+"..."+sheet.getColumns());
			         
			          Cell tableStart=sheet.getCell(0,0);
			         
			        
			          System.out.println("+++++++++++++++++++++"+tableStart.getColumn());
			          
			          
			          
			          
			          int startRow,startCol, endRow, endCol,ci,cj;
			           
			          startRow=tableStart.getRow();//2
			          
			          startCol=tableStart.getColumn();//1
			         // System.out.println("startRow="+startRow+"startCol="+startCol+"..");
			          //Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);   
			          Cell tableEnd= sheet.getCell(3,4);
			          //System.out.println("+++++++++++++++++++++"+tableEnd.getContents());
			 
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
			                  tabArray[ci][cj]=sheet.getCell(j,i).getContents().toString();
			              }
			          }
			      }
			      catch (Exception e)    {
			          System.out.println("Please check if file path, sheet name and tag name are correct");
			           
			      }
			 
			      return(tabArray);
			  }

			  
}