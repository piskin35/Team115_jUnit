package Day07_Assertion_CheckBox_Radio_Dropdown_Alert;

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

public class C09_JSAlert {

    // set required options
    // go to the https://the-internet.herokuapp.com/javascript_alerts
    // create 3 different methods to click jsAlerts
    // handle them

    WebDriver driver;

    @Before
    public void setUp()  throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsFirstbutton = driver.findElement(By.xpath("//button[text() ='Click for JS Alert']"));
        jsFirstbutton.click();

        Thread.sleep(3000);

        //to accept the JS alert we need to switch to alert

        driver.switchTo().alert().accept();

        WebElement actualResult = driver.findElement(By.id("result"));

        String expectedResult = "You successfully clicked an alert";
        String actualResultText = actualResult.getText();

        Assert.assertEquals("It is failed because result is not matching",expectedResult,actualResultText);


    }

    @Test
    public void test02() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirmbutton = driver.findElement(By.xpath("//button[text() ='Click for JS Confirm']"));
        jsConfirmbutton.click();

        Thread.sleep(3000);

        driver.switchTo().alert().accept();

        WebElement actualResult = driver.findElement(By.id("result"));

        String expectedResult = "You clicked: Ok";
        String actualResultText = actualResult.getText();
        Assert.assertEquals("It is failed because result is not matching",expectedResult,actualResultText);

        jsConfirmbutton.click();
        driver.switchTo().alert().dismiss();

        String expectedResult2 = "You clicked: Cancel";
        String actualResultText2 = actualResult.getText();
        Assert.assertEquals("It is failed because result is not matching",expectedResult,actualResultText);

    }

    @Test
    public void test03() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jspromtbutton = driver.findElement(By.xpath("//button[text() ='Click for JS Prompt']"));
        jspromtbutton.click();

        Thread.sleep(3000);

        String textToSend = "WiseQuarter";

        driver.switchTo().alert().sendKeys(textToSend);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        WebElement actualResult = driver.findElement(By.id("result"));

        String expectedResult = "You entered: " + textToSend;
        String actualResultText = actualResult.getText();
        Assert.assertEquals("It is failed because result is not matching",expectedResult,actualResultText);

        jspromtbutton.click();
        driver.switchTo().alert().dismiss();

        String expectedResult2 = "You entered: null";
        String actualResultText2 = actualResult.getText();
        Assert.assertEquals("It is failed because result is not matching",expectedResult,actualResultText);


    }
}










