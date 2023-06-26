package Day07_Assertion_CheckBox_Radio_Dropdown_Alert;

import com.github.javafaker.Faker;
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

public class C04_RadioButton {

    //Create the required structure and complete the following task.
    // a. Go to the given web page.https://facebook.com
    // b. Accept cookies (Skipped: I wasn't asked for cookies)
    // c. Press the Create an account button
    // D. Locate the radio button elements and choose the one that suits you
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException{
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
    public void test01(){
       driver.get("https://www.facebook.com/");

        WebElement createNewAccount = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createNewAccount.click();

        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value= '2']"));
        maleRadioButton.click();

        Assert.assertTrue(maleRadioButton.isSelected());// this is the verification


    }
}
