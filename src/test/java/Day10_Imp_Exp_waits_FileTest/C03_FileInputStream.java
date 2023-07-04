package Day10_Imp_Exp_waits_FileTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C03_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {

        String filePath = "C:\\Users\\piski\\Desktop\\NewFile.txt";

        FileInputStream fis = new FileInputStream(filePath);

        //We need to create dynamic path
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\piski\IdeaProjects\com.Team115JUnit
        //if we want to use full project path

        System.out.println(System.getProperty("user.home"));
        //C:\Users\piski
        //to create dynamic we can getProperty from the system. By changing some parts I can have dynamic path
        //path is going to work on all computers (file is on desktop)

        String dynamicPath = System.getProperty("user.home")+ "\\Desktop\\NewFile.txt";
        FileInputStream fis2 = new FileInputStream(dynamicPath);


    }
}
