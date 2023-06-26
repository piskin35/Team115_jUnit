package Day06_JUnit_Framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClass_AfterClass {

    // create 3 test method
    // 1) go to the amazon.com and test that you are in amazon.com
    // 2) search for nutella and test that you have searched for nutella
    // 3) test that there are more than 30 result of nutella

    //When we use beforeClass or afterClass annotations, we have to make driver static (rule of JUnit)
    //Also the methods for beforeClass and afterClass should be static
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    // 1) go to the amazon.com and test that you are in amazon.com

    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
        String expectedURL = "amazon.com";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("Test is passed");
        }else{
            System.out.println("Test is failed");
        }
    }





    // 2) search for nutella and test that you have searched for nutella
    @Test
    public void test02(){
        String searchedText = "Nutella";
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys( searchedText + Keys.ENTER);

        WebElement resultText = driver.findElement(By.cssSelector("[class='a-section a-spacing-small a-spacing-top-small']"));
        String resultTextstr = resultText.getText();

        if(resultTextstr.contains(searchedText)){
            System.out.println("Test is passed");
        }else{
            System.out.println("Test is failed");
        }
    }


    // 3) test that there are more than 30 result of nutella

    @Test
    public void test03(){
        WebElement resultText = driver.findElement(By.cssSelector("[class='a-section a-spacing-small a-spacing-top-small']"));
        String resultTextstr = resultText.getText();
        System.out.println(resultTextstr);
        String [] arr = resultTextstr.split(" ");
        int expectedNum = 30;
        int actualNUm = Integer.parseInt(arr[2]);
        System.out.println(actualNUm);

//        if(actualNUm>expectedNum){
//            System.out.println("test is passed");
//        }else{
//            System.out.println("test is failed");
//        }
        Assert.assertTrue(actualNUm>expectedNum); //Thanks to assert left side report matches with actual result of the test
    }



}
