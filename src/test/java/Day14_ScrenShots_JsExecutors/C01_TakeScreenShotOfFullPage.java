package Day14_ScrenShots_JsExecutors;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_TakeScreenShotOfFullPage extends TestBase {

    @Test
    public void test01() throws IOException {
        // go the amazon.com
        // write Nutella to searchbox
        // and test that result has nutella keyword

        driver.get("https://amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));

        String actualResultStr = result.getText();
        String expectedResultStr = "Nutella";

        Assert.assertTrue(actualResultStr.contains(expectedResultStr));

        //Take a screenShot of the full page

//        //1) Create a "TakesScreenshot" class object
//        TakesScreenshot tss = (TakesScreenshot) driver;
//
//        //2)Create a file path for ss
//        String filePath = "target/fullPageSS/ScreenShotSS.jpeg";
//
//        //3)Create File
//        File fullPageSS = new File(filePath);
//
//        //4)Creating tem file to save ss
//        File tempFile = tss.getScreenshotAs(OutputType.FILE);
//
//        //5)Copying ss from temp file to original file
//        FileUtils.copyFile(tempFile, fullPageSS);

        //lET'S WRITE A METHOD TO TAKE SCREENSHOT FOR ABOVE STEPS

        ReusableMethods.fullPageScreenShot(driver);


    }
}
