package utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReusableMethods {

    public static void waitFor(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {

        }
    }

    public static void getValueOfExcelFileUsingRowAnCell(String filePath, int row, int cell) {

        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
        }

        System.out.println(workbook.getSheet("Sayfa1").getRow(row).getCell(cell));

    }
}
