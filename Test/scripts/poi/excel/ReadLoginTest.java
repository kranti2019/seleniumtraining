package scripts.poi.excel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;

public class ReadLoginTest {
	public static Workbook book;
	public static Sheet sheet;
	public static String testdata_sheet="Test\\resources\\login.xls";
	//Workbook wb = WorkbookFactory.create(file);
	
  @Test
  public static Object[][] readExcel(String sheetName) throws IOException
  {
	  FileInputStream file=null;
//	  //Find the file extension by spliting file name in substring and getting only extension name
//	    //indexOf gives the index of . in the file name
//	    //substring method splits the string starting from index of . to the end
//	    String fileExtensionName = testdata_sheet.substring(testdata_sheet.indexOf("."));
//	  
//	   
//	    //Check condition if the file is xlsx file
//	    if(fileExtensionName.equals(".xlsx")){
//	    //If it is xlsx file then create object of XSSFWorkbook class
//	    	book= new XSSFWorkbook(file);
//	    }
//	    //Check condition if the file is xls file
//	    else if(fileExtensionName.equals(".xls")){
//	        //If it is xls file then create object of HSSFWorkbook class
//	    	book = new HSSFWorkbook(file);
//	    }
	  try
	  {
		   file = new FileInputStream (testdata_sheet);
		   
	  } catch (FileNotFoundException e) 
	  {
	      e.printStackTrace();
	  }
	  
	  try
	  {
		   book = WorkbookFactory.create(file);
		   
	  } catch (IOException e) 
	  {
	      e.printStackTrace();
	  
	  }
	  sheet = book.getSheet(sheetName);
	  
	  
	  
	  Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	  for (int i = 0; i < sheet.getLastRowNum(); i++) {
		        for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++)
		        {
	            data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		        }
	  }
	  return data;
	  
	  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
