package Day09_WindowHandle_Action_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MoveToElement extends TestBase {

    @Test
    public void test01(){
        //1- Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2- Move the mouse over the menu to open the “Account & Lists” menu in the upper right section.
        Actions actions = new Actions(driver);

        WebElement targetToMove = driver.findElement(By.xpath("//span[text()='Account & Lists']"));

        actions.moveToElement(targetToMove).perform();//********moveToElement() we hover over web elements

        //3- Press the “Create a list” button

        WebElement createAListButton = driver.findElement(By.xpath("//span[text()='Create a List']"));
        createAListButton.click();

        //4- Test that "Your Lists" is written on the page that opens
        WebElement yourList = driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(yourList.isDisplayed());
    }
}
