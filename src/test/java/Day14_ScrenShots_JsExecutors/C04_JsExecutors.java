package Day14_ScrenShots_JsExecutors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_JsExecutors extends TestBase {

    @Test
    public void test01(){
        driver.get("https://amazon.com");

        WebElement musicElement = driver.findElement(By.xpath("//a[text()='Music']"));
        //musicElement.click();

        //Let's use Js executors

        //1) We need to create js executor object

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //by using js we will click
        js.executeScript("arguments[0].click()", musicElement);

        js.executeScript("alert(\"That's it\")");



    }
}
