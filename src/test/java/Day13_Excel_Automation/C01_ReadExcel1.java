package Day13_Excel_Automation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel1 {
    @Test
    public void test() throws IOException {
        //When we use an excel file, actually we are not using original file. We create a copy and work on it

        //file path from content root
        String filePath = "src/test/java/Day13_Excel_Automation/countries.xlsx";

        //adding file to project creating a fis object
        FileInputStream fis = new FileInputStream(filePath);

        //we will create a copy of the file to work on
        Workbook workbook = WorkbookFactory.create(fis);

        //now we have a copy of excel file
        //step by step we will try to reach data

        Sheet sheet = workbook.getSheet("Sayfa1"); // reaching the specific excel sheet

        //Let's try to reach row 5 //Index numbers starts from zero
        Row row = sheet.getRow(4);

        //Let's reach 3rd cell
        Cell cell = row.getCell(2);//Andorra

        System.out.println("value of the cell: "+ cell);

    }
}
