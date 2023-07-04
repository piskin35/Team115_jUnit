package Day10_Imp_Exp_waits_FileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {
             //1. Let's create a class under the Tests package: C04_FileDownload
            //Go to https://the-internet.herokuapp.com/download
            //3. Download the person.png file my hand
            //4 . Let 's test if the file was downloaded successfully

    @Test
    public void test01(){
        //Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

        //3. Download the person.png file my hand
//        driver.findElement(By.xpath("//a[text() = 'person.png']"));
        driver.findElement(By.linkText("person.png")).click();
        //4 . Let 's test if the file was downloaded successfully

        //"C:\Users\piski\Downloads\person.png"

        String downloadedFileDynamicPath = System.getProperty("user.home")  + "\\Downloads\\person.png";

        Assert.assertTrue(Files.exists(Paths.get(downloadedFileDynamicPath)));
    }


}
