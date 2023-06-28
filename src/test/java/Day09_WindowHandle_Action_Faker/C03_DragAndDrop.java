package Day09_WindowHandle_Action_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_DragAndDrop extends TestBase {
    //Let's create a new class: MouseActions2
    //1- Let's go to https://demoqa.com/droppable
    //2- Let's hold the "Drag me" button and drop it above the "Drop here" box
    //3-  Test that,Instead of “Drop here” text “Dropped!” text is there

    @Test
    public void test01(){
        //1- Let's go to https://demoqa.com/droppable
        driver.get("https://demoqa.com/droppable");

        //2- Let's hold the "Drag me" button and drop it above the "Drop here" box
        Actions actions = new Actions(driver);

        WebElement dragMeBox = driver.findElement(By.cssSelector("[id='draggable']"));
        WebElement dropAreaBox = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(dragMeBox, dropAreaBox).perform();// This action drags and drops //****Please Don't FORGET perform() method
        //****Please Don't FORGET perform() method


        ReusableMethods.waitFor(2);

        //3-  Test that,Instead of “Drop here” text “Dropped!” text is there
        WebElement droppedElement = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        String actualText = droppedElement.getText();
        String expectedText = "Dropped!";

        Assert.assertEquals(actualText, expectedText);
    }
}
