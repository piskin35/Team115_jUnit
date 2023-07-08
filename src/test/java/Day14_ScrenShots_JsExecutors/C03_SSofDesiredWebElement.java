package Day14_ScrenShots_JsExecutors;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_SSofDesiredWebElement extends TestBase {

    @Test
    public void test01() throws IOException {
        // go the amazon.com
        // write Nutella to searchbox
        // and test that result has nutella keyword

        driver.get("https://amazon.com");


        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        ReusableMethods.getSSofWebElement(searchBox);
        searchBox.sendKeys("Nutella" + Keys.ENTER);


        WebElement result = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));

        String actualResultStr = result.getText();
        String expectedResultStr = "Nutella";

        Assert.assertTrue(actualResultStr.contains(expectedResultStr));

        //take ss of result element

//        //Create file path
//        LocalDateTime ldt = LocalDateTime.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//        String date = ldt.format(dtf);
//        String filePath = "target/SSofDesiredWebElement/SsOfDesiredElement" + date+ ".jpeg";
//
//        //original file
//        File elementSS = new File(filePath);
//
//        //temp file object
//        File tempFile = result.getScreenshotAs(OutputType.FILE);
//
//        //copy ss from temp to original object
//        FileUtils.copyFile(tempFile,elementSS);

        ReusableMethods.getSSofWebElement(result);


    }
}
