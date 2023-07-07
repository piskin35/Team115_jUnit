package Day13_Excel_Automation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel2 {

    // let's reach row 1 and column 2 of sheet named Sayfa1
    //  test that 2. row and 4.cell value is Kabil
    // let's try to find how many rows are being used in sheet named Sayfa2
    // try to find how many used rows we have in the second sheet

    @Test
    public void test01() throws IOException {
        //to work on a file, first need to complete following steps
        //1) file path from content root
        String filePath = "src/test/java/Day13_Excel_Automation/countries.xlsx";
        //2) adding file to project creating a fis object
        FileInputStream fis = new FileInputStream(filePath);
        //3) we will create a copy of the file to work on
        Workbook workbook = WorkbookFactory.create(fis);

        // let's reach row 2 and column 2 of sheet named Sayfa1
        System.out.println(workbook.getSheet("Sayfa1").getRow(1).getCell(1));//Kabul
            //2.way: store cell data in a string variable and print it
            String desiredCellStr = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();
            System.out.println(desiredCellStr); //Kabul

        //  test that 2. row and 4.cell value is Kabil
        String actualCellValue = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedCellValue = "Kabil";
        Assert.assertEquals(expectedCellValue, actualCellValue);

        // let's try to find how many "rows" are being used in sheet named Sayfa2 including empty once
        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum());//23  is the last index number

        // try to find how many rows "filled with data " we have in the second sheet
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());//8 amount of used rows

        //Let's create a map from excel document

        Map<String, String> countriesMap = new TreeMap<>();

        String key = "";
        String value = "";
        int lastRowNumberOfSheet = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 1; i <= lastRowNumberOfSheet; i++) {
            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() +"-"+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() +"-"+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            countriesMap.put(key, value);
        }

        System.out.println(countriesMap);

        for (String each: countriesMap.keySet()) {
            System.out.println();
            System.out.print(each);
            System.out.print(": " + countriesMap.get(each));
        }

    }


}
