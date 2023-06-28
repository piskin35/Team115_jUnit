package Day08_Auth_WindaowsHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_IFrame {

    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void Test01(){

//        1) Go to https://the-internet.herokuapp.com/iframe.

        driver.get("https://the-internet.herokuapp.com/iframe");

//        2 ) Create a method: iframeTest
//                - “An IFrame containing….” Test that the text is accessible and print it in the
//        console.

        WebElement bigText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(bigText.isDisplayed());
        System.out.println(bigText.getText());

//                - Write "Hello World!" to Text Box.

        //1) To swiCth to Iframe i have used iframe web element
//        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
//        driver.switchTo().frame(iFrame);

        //2) Used Id of iframe to switch
//        driver.switchTo().frame("mce_0_ifr");

        //3) Used index of iframe to switch
        driver.switchTo().frame(0);

        //All three way of switching to IFRAME works.
        WebElement textbox = driver.findElement(By.tagName("p"));
        textbox.clear();
        textbox.sendKeys("Hello World!!!");


//        - Verify that the text of the “Elemental Selenium” link at the bottom of the
//        TextBox is visible and print it on the console.

        //Before I do anything on the default page I need to switch back to default page

        //1. way
        //driver.switchTo().parentFrame();

        //2. way
        driver.switchTo().defaultContent();

        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));

        System.out.println(elementalSelenium.getText());

        Assert.assertTrue(elementalSelenium.isDisplayed());




    }
}
