package Task7;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.testng.Assert.*;

public class ComparisonTest {

    @Test
    public void testComparisonAGreaterThanB() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Comparison.comparison(10, 5);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains("Число a больше чем b"));
    }

    @DataProvider(name = "comparisonData")
    public Object[][] comparisonData() {
        return new Object[][]{
            {10, 5, "Число a больше чем b"},
            {5, 10, "Число b больше чем a"},
            {5, 5, "Числа a и b равны"}
        };
    }

    @Test(dataProvider = "comparisonData")
    public void testComparisonParameterized(int a, int b, String expectedOutput) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Comparison.comparison(a, b);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains(expectedOutput));
    }
}