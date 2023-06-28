package Day08_Auth_WindaowsHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WindowsHandle {
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
        //driver.close(); //this one only close the last tab

        driver.quit();//this one closes all the tabs
    }


    @Test
    public void test01() throws InterruptedException {
//  Go to https://the-internet.herokuapp.com/windows.
        driver.get("https://the-internet.herokuapp.com/windows");
//  Verify that the text on the page is “Opening a new window”.
        WebElement openingtext = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(openingtext.isDisplayed());

//  Verify that the page title is “The Internet”.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
//    Save first apge handle value
        String firstPageHandleValue = driver.getWindowHandle();
//  Click the Click Here button.
        WebElement clickHereButton = driver.findElement(By.xpath("//a[text() = 'Click Here']"));
        clickHereButton.click();
//  After returning to the previous window, the page title is “The Internet”. verify
        driver.switchTo().window(firstPageHandleValue);
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle2);
    }
}
