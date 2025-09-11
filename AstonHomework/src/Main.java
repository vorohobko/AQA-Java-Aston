
import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;
import Task9.MtsTest;

public class Main {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
       
        List<Class<?>> classes = new ArrayList<>();
        classes.add(MtsTest.class);
        
        testNG.setTestClasses(classes.toArray(new Class[0]));
        testNG.run();
