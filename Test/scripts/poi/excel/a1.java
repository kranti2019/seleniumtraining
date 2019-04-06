package scripts.poi.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a1 {

	public static void main(String[] args) throws IOException {
		//Create an object of ReadGuru99ExcelFile class

		ReadExcelPOI  objExcelFile = new ReadExcelPOI ();

	    //Prepare the path of excel file

	    String filePath = System.getProperty("user.dir")+"\\Test\\resources\\data";

	    //Call read file method of the class to read data

	    objExcelFile.readExcel(filePath, "login1.xls", "LoginData");

	    }

	}