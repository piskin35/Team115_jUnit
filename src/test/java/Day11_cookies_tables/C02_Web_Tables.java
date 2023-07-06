package Day11_cookies_tables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_Web_Tables extends TestBase {

    //Go to "https://www.amazon.com"
    //Scroll to the bottom of the page
    //Print the entire body of the web table
    //Test that the number of rows in the web table is 9
    //Print all lines
    //Test that the number of columns in the web table is 13
    //print column 5
    //Create a method that takes the number of rows and columns as parameters and returns the information in the cell

    @Test
    public void test01(){
        //Go to "https://www.amazon.com"
        driver.get("https://amazon.com");

        //Scroll to the bottom of the page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //Print the entire body of the web table
        WebElement tableBody = driver.findElement(By.xpath("//tbody"));
        //System.out.println(tableBody.getText()); We were not able to print the tbody directly

        //Test that the number of rows in the web table is 12
        List<WebElement> trList = driver.findElements(By.xpath("//tbody/tr"));

        int expectedNumberOfRows = 12;
        int actualNumberOfRows = trList.size();

        Assert.assertEquals(expectedNumberOfRows, actualNumberOfRows);

        //Print all lines
       // System.out.println(trList);
        //I should loop the webElement List with getText()

        for (WebElement each: trList) {
            System.out.println(each.getText());
        }



        //Test that the number of columns in the web table is 12
        List<WebElement> columnNumber = driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int expectedColumnNumber = 11;
        int actualColumnNumber = columnNumber.size();

        Assert.assertEquals(expectedColumnNumber, actualColumnNumber);

        //print column 5
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<WebElement> column5 = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement each: column5) {
            System.out.println(each.getText());
        }


        //Create a method that takes the number of rows and columns as parameters and returns the information in the cell

        System.out.println("===========================================================");
        WebElement cellValue = valueOfCell(3,7);
        System.out.println(cellValue.getText());
    }

    public WebElement valueOfCell(int rowNumber, int columnNumber) {
        // //tbody/tr[        3         ]/td[        7     ]

        String xpath =  "//tbody/tr["  +rowNumber+ "]/td[" +columnNumber+ "]";


        WebElement cellValueOfTable = driver.findElement(By.xpath(xpath));

        return cellValueOfTable;

    }
}
