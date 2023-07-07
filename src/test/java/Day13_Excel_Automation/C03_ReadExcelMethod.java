package Day13_Excel_Automation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcelMethod {
    @Test
    public void test01() throws IOException {
        String filePath = "src/test/java/Day13_Excel_Automation/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(2));//Cezayir

        //lets' use a method to get specific data

        ReusableMethods.getValueOfExcelFileUsingRowAnCell(filePath,3, 2);//Cezayir
        ReusableMethods.getValueOfExcelFileUsingRowAnCell(filePath, 13, 3);//Manama

    }



}
