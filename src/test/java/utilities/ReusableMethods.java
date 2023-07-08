package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

    public static void fullPageScreenShot(WebDriver driver) {

        //1) Create a "TakesScreenshot" class object
        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String date = ldt.format(dtf);

        //2)Create a file path for ss
        String filePath = "target/fullPageSS/ScreenShotSS" + date + ".jpeg";

        //3)Create File
        File fullPageSS = new File(filePath);

        //4)Creating tem file to save ss
        File tempFile = tss.getScreenshotAs(OutputType.FILE);

        //5)Copying ss from temp file to original file
        try {
            FileUtils.copyFile(tempFile, fullPageSS);
        } catch (IOException e) {
        }
    }

    public static void getSSofWebElement(WebElement webelement) {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String date = ldt.format(dtf);
        String filePath = "target/SSofDesiredWebElement/SsOfDesiredElement" + date+ ".jpeg";


        File elementSS = new File(filePath);
        File tempFile = webelement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tempFile,elementSS);
        } catch (IOException e) {
        }
    }
}
