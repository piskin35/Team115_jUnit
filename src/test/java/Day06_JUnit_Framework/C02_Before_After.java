package Day06_JUnit_Framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Before_After {

    // create 3 different test methods
    // for each method create a driver

    //1) go to the https://www.amazon.com
    //2) wisequarter.com
    //3) youtube.com
    // in all method print the title of the website

    WebDriver driver;
    //To be able to use the driver object inside other methods we declare it in class level

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("Before is executed");
    }

    @After
    public void tearDown(){
        driver.close();
        System.out.println("After is executed");
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test02(){
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test03(){
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
    }

}
