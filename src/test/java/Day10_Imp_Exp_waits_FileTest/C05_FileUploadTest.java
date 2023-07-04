package Day10_Imp_Exp_waits_FileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUploadTest extends TestBase {
    //Let's go to https://the-internet.herokuapp.com/upload
    // create a dynamic path for the file we want to upload
    //Select the file you want to upload .
    //Hit the upload button .
    //“File Uploaded!” Let's test that the text is displayed .

    @Test
    public void Test01() throws InterruptedException {
        //Let's go to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //Let's locate the chooseFile button
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        //Let's create a dynamic path
        String dynamicPath = System.getProperty("user.home") + "\\Desktop\\NewFile.txt";

        //Select the file you want to upload .
        chooseFileButton.sendKeys(dynamicPath);

        Thread.sleep(3000);
        //Hit the upload button .
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” Let's test that the text is displayed

        WebElement uploadedText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploadedText.isDisplayed());
    }


}
