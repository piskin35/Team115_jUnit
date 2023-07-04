package Day10_Imp_Exp_waits_FileTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_Imp_Exp_Wait {

    //1. Create a class : WaitTest
    //2. Create two methods: implicitWaitTest() , explicitWaitTest()
    //
    // Test the following steps for both methods.
    //3. Go to https://the-internet.herokuapp.com/dynamic_controls.
    //4. Press the Remove button.
    //5. “It's gone!” Verify that the message is displayed.
    //6. Press the Add button
    //7. Test that it's back message appears
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);//Hard wait
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);//Hard wait
        driver.close();
    }

    //Both implicit and explicit wait is soft wait that coming from Selenium

    @Test
    public void implicitWaitTest(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //Implicit wait

        //3. Go to https://the-internet.herokuapp.com/dynamic_controls.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Press the Remove button.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It's gone!” Verify that the message is displayed.
        WebElement message1 = driver.findElement(By.id("message"));
        Assert.assertTrue(message1.isDisplayed());

        //6. Press the Add button
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. Test that it's back message appears
        WebElement message2 = driver.findElement(By.id("message"));
        Assert.assertTrue(message2.isDisplayed());
    }

    @Test
    public void explicitWaitTest(){

        //3. Go to https://the-internet.herokuapp.com/dynamic_controls.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Press the Remove button.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It's gone!” Verify that the message is displayed.
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));


        WebElement message1 = driver.findElement(By.id("message"));
        //wait.until(ExpectedConditions.visibilityOf(message1));
        Assert.assertTrue(message1.isDisplayed());

        //6. Press the Add button
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //7. Test that it's back message appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        WebElement message2 = driver.findElement(By.id("message"));
        Assert.assertTrue(message2.isDisplayed());
    }


}
