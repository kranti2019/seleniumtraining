package scripts.poi.excel;
import java.io.IOException;


public class ReadExcelData {

	public static void main(String[] args) {
		try {
		      ExcelOperationsUsingPOI.readExcel("Test\\resources\\data", "login1.xls", "LoginData");
		     
		    } catch (IOException e) {
		      e.printStackTrace();
		    } 
		  }

	public static String[][] getExcelData(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
		}