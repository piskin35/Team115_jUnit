package Day10_Imp_Exp_waits_FileTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Implicit_Wait {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //We have set wait time for each step we use in selenium test. This implicit wait is coming from selenium
        //Implicit wait is global. For each steps it will wait up to 15 seconds
        //If a step is completed before 15 seconds. Java will not wait to run next step entire 15 second, It will just continue

        //Thread.sleep();  is coming from JAVA. It is a hard sleep. It will wait for the set time no matter what?

        //explicit wait : if we want ot set a longer wait time than implicit wait for a specofoc web element, We can use explicit waits
        //explicit waits are also coming from Selenium

    }
}
