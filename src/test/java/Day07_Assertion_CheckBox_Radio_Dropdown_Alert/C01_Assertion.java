package Day07_Assertion_CheckBox_Radio_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;

public class C01_Assertion {


    int p1age = 66;
    int p2age = 70;
    int p3age = 77;
    int retirementAge = 70;


    @Test
    public void test01(){
        if(p1age>retirementAge){
            System.out.println("Test is passed");
        }else{
            System.out.println("Test is failed");
        }

        Assert.assertTrue(p1age>retirementAge);
    }

    @Test
    public void test02(){
        Assert.assertFalse(p1age>retirementAge);
    }

    @Test
    public void test03(){
        Assert.assertEquals(p1age, retirementAge); //Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(14,95);
    }
}
