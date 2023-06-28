package Day09_WindowHandle_Action_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01(){
        //1 - Let's create a Class KeyboardActions1
        //2 - Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3 - Type Samsung A71 using actions methods in the search box and press Enter to search
        Actions actions = new Actions(driver);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.click();
        //Type Samsung A71
        actions.keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung")
                .keyDown(Keys.SHIFT)
                .sendKeys(" a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71"+ Keys.ENTER)
                .perform();


        //4 - test that the search is completed in amazon website
        WebElement searchedText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

        String actualText = searchedText.getText();
        String expectedText = "Samsung";
        Assert.assertTrue(actualText.contains(expectedText));

    }

}
