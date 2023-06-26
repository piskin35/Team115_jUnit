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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C08_DropDown {

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
    public void test01(){

        driver.get("https://amazon.com/");

        WebElement dropdownElement = driver.findElement(By.id("searchDropdownBox"));
        //Selenium developers have created "Select" class for us to handle dropdowns
        //when we create a Select class object we need to pass dropdown web element as a parameter for the Select constructor

        Select select = new Select(dropdownElement);

        //to select an option from dropdown list we can use visible text
        select.selectByVisibleText("Baby");

        //
       String expectedSelectedOption = "Baby";
       String actualSelectedOption = select.getFirstSelectedOption().getText();
       System.out.println(actualSelectedOption);

       driver.navigate().refresh(); //When we refresh we can encounter a StaleElementReferenceException
        //This is going to requre use to re-stor our elements


        dropdownElement = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(dropdownElement);

        Assert.assertEquals("they are not equal",expectedSelectedOption, actualSelectedOption);

        List<WebElement> listOfOptions = select.getOptions();

        for (WebElement each: listOfOptions) {
            System.out.println(each.getText());
        }

        System.out.println(listOfOptions.size());//54

        //HW: Assert the amount of option in the dropdown list


        //Select by index number. index numbers start from zero
        select.selectByIndex(10);
        System.out.println(select.getFirstSelectedOption().getText());

        //Select by value
        select.selectByValue("search-alias=alexa-skills");
        System.out.println(select.getFirstSelectedOption().getText());


    }


}
