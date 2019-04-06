package script.ddt.excel;

import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
public class DDTNicheThyself {
	 WebDriver driver;
     
	    @DataProvider (name = "ReadFromXLS") 
	    public Object[][] getDataFromXLS(){
	          Object[][] retObjArr=getTableArray("Test\\resources\\data\\login.xls",
	                  "LoginData", "StartAndEnd");
	            return(retObjArr);    
	 
	    }
	     
	     
	 
	    @Test (dataProvider = "ReadFromXLS")
	    public void loginToNicheThyself(String user, String password) {
	          driver.get("http://selenium-examples.nichethyself.com");
	          driver.findElement(By.name("username")).sendKeys(user);
	          driver.findElement(By.name("password")).sendKeys(password);
	          driver.findElement(By.name("loginform")).findElement(By.tagName("button")).click();       
	    }
	     
	     
//	    @Test (dataProvider = "ReadFromCSV",dataProviderClass=MyDataProviders.class)
//	    public void loginToNicheThyself1(String user, String password) {
//	          driver.get("http://selenium-examples.nichethyself.com");
//	          driver.findElement(By.name("username")).sendKeys(user);
//	          driver.findElement(By.name("password")).sendKeys(password);
//	          driver.findElement(By.name("loginform")).findElement(By.tagName("button")).click();       
//	    }
//	     
	     
	     
	     @BeforeMethod
	      public void beforeMethod() {
	            System.setProperty("webdriver.gecko.driver", "Test\\resources\\geckodriver64bit.exe");
	            System.setProperty("webdriver.chrome.driver", "Test\\resources\\chromedriver.exe");
	 
	        //  driver = new FirefoxDriver();
	            driver = new ChromeDriver();
	 
	      }
	 
	      @AfterMethod
	      public void afterMethod() {
	          driver.quit();
	      }
	       
	      public String[][] getTableArray(String xlFilePath, String sheetName, String tableName){
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