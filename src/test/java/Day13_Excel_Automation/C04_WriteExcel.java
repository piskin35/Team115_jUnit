package Day13_Excel_Automation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {

    @Test
    public void test01() throws IOException {

        //To reach the cells we do following
        String filePath = "src/test/java/Day13_Excel_Automation/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        //To write on the copied file we use createCell()
        workbook.getSheet("Sayfa1").getRow(1).createCell(3).setCellValue("DONE");
        workbook.getSheet("Sayfa1").getRow(10).createCell(6).setCellValue("DONE");
        workbook.getSheet("Sayfa1").getRow(11).createCell(6).setCellValue("DONE");
        workbook.getSheet("Sayfa1").getRow(12).createCell(6).setCellValue("DONE");

        //****We must create FileOutputStream object to kind of push the changes to original file
        FileOutputStream fos = new FileOutputStream(filePath);
        //We write changes to original file with the  workbook.write(fos);
        workbook.write(fos);

        workbook.close(); //workbook is closed


    }
}
