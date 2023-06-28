package Day09_WindowHandle_Action_Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class C01_WindowsHandle extends TestBase {
//    WebDriver driver;
//
//    @Before
//    public void setUp() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        Thread.sleep(3000);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    }
//
//    @After
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//    }

    @Test
    public void test01(){

        // go to the "https://the-internet.herokuapp.com/iframe"
        driver.get("https://the-internet.herokuapp.com/iframe");

        // click on selenium link
        driver.findElement(By.linkText("Elemental Selenium")).click();

//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Elemental Selenium";
//
//        System.out.println(actualTitle);
//
//        Assert.assertTrue(actualTitle.contains(expectedTitle));

        /*
        When we click on a link that opens a new tab, we need to swith that tab to be able to automate the new tab
        If we don't switch my automation focus will be on old tab
        We need to use getWindowHandles
         */

        String firstTabHandleValue = driver.getWindowHandle();
        String secondTabHandleValue = "";

        Set<String> handleValues = driver.getWindowHandles();


        for (String each: handleValues) {
            if(!firstTabHandleValue.equals(each)){
                secondTabHandleValue = each;
            }
        }

        //now I can use secondHandle]value to switch the second tab

        driver.switchTo().window(secondTabHandleValue);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Elemental Selenium";
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        driver.findElement(By.linkText("Join the mailing list")).click();


        //Now switch back to first tab

        driver.switchTo().window(firstTabHandleValue);
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "The Internet";
        System.out.println(actualTitle2);
        Assert.assertEquals(actualTitle2, expectedTitle2);

        ReusableMethods.waitFor(4);// this is going to wait for 4 second



    }
}
