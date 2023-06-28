package Day08_Auth_WindaowsHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C03_NewWindow extends TestBase {

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
//        //driver.close(); //this one only close the last tab
//
//        driver.quit();//this one closes all the tabs
//    }


    @Test
    public void test01(){
        //Go to the amazon.com
        driver.get("https://amazon.com/");

        //Test if the page title contains “Amazon”
        String actualUrl=driver.getCurrentUrl();
        String expectedKeyWord = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedKeyWord));

        //Assign Page's window handle to a String variable
        String firstTabHandleValue = driver.getWindowHandle();

        //Create a new tab and go to wisequarter.com in the tab that opens
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com/");

        //Test if the page title contains “wise quarter”
        String actualUrl2=driver.getCurrentUrl();
        String expectedKeyWord2 = "wisequarter.com";
        Assert.assertTrue(actualUrl2.contains(expectedKeyWord2));

        // Create a new window and go to walmart.com on the page that opens
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://walmart.com/");

        String thirdTabHandleValue = driver.getWindowHandle();

        //Test if the page title contains “Walmart”
        String actualUrl3=driver.getCurrentUrl();
        String expectedKeyWord3 = "walmart";
        Assert.assertTrue(actualUrl3.contains(expectedKeyWord3));

        //Go back to the first page and test your return to the amazon page
        driver.switchTo().window(firstTabHandleValue);
        String actualUrl4=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl4.contains(expectedKeyWord));

        //go back to walmart tab

        driver.switchTo().window(thirdTabHandleValue);

        String actualUrl5=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl5.contains(expectedKeyWord3));
    }



    }
