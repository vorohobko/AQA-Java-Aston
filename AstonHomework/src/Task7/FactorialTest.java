package Task7;


import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.getFactorial(0), 1);
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(Factorial.getFactorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegativeNumber() {
        Factorial.getFactorial(-5);
    }

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorialParameterized(int input, int expected) {
        assertEquals(Factorial.getFactorial(input), expected);
    }
}