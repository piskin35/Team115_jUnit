package Day06_JUnit_Framework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C01_ByeByeMainMethod {

    @Before
    public void setUp(){
        System.out.println("SetUp Method is executed.");
    }


    @After
    public void tearDown(){
        System.out.println("tearDown method is executed");
    }

    @Test
    //Thanks to the @Test annotation a method can be executed
    public void test01(){
        System.out.println("test01 is executed.");
    }

    @Test
    public void test02(){
        System.out.println("Test02 is executed.");
    }





}
