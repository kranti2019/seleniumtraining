package script.ddt.excel;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class MyDataProviders {
	@DataProvider (name = "ReadFromCSV") 
    public Iterator getDataFromCSV(){
          Collection<String[]> retObjArr=null;
        try {
            retObjArr = getTestData("Test\\resources\\data\\logincsv.csv");
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