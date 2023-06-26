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

public class C03_Checkbox {

    //Create the required structure and complete the following task.
    // a. Go to the given web page. https://the-internet.herokuapp.com/checkboxes
    // b. Locate the checkbox1 and checkbox2 elements.
    // c. Click the checkbox if Checkbox1 is not selected
    // D. Click the checkbox if Checkbox2 is not selected

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
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        if(!checkBox2.isSelected()){
            checkBox2.click();
        }

        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());

    }

}
