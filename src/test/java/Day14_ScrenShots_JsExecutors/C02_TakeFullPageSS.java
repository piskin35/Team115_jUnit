package Day14_ScrenShots_JsExecutors;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_TakeFullPageSS extends TestBase {

    @Test
    public void test01(){
        //wisequarter
        // test that you are in wisequarter
        // take a SS
        driver.get("https://wisequarter.com");

        Assert.assertTrue(driver.getCurrentUrl().contains("wisequarter"));

        //Take ss
        ReusableMethods.fullPageScreenShot(driver);
    }
}
