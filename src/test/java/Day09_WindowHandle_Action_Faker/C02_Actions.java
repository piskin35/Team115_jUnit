package Day09_WindowHandle_Action_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01(){
        //1- Let's create a new class: C02_Actions --Already done
        //2- Go to https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Right-click on the drawn area
        WebElement rightClickArea = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);//This action object will help me to do mouse and keyboard action

        actions.contextClick(rightClickArea).perform();

        ReusableMethods.waitFor(2);

        //4- Test that the text in Alert is “You selected a context menu”.
        String actualAlertText =driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";
        Assert.assertEquals("They are not EQUAL.",actualAlertText, expectedAlertText);

        //5- Let's close the alert by saying OK
        driver.switchTo().alert().accept();

        //6- Click on Elemental Selenium link
        WebElement elementalSeleniumLink = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSeleniumLink.click();

        //Homework
        //Tip: C01_WindowsHandle page has everything to switch new tab

        //7- Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.

        //8- Switch back to first tab and verify the title

    }
}
