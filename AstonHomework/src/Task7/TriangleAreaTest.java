package Task7;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.*;

public class TriangleAreaTest {

    @Test
    public void testCalculateAreaPositiveNumbers() {
        assertEquals(TriangleArea.calculateArea(10, 5), 25.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateAreaNegativeBase() {
        TriangleArea.calculateArea(-10, 5);
    }

    @DataProvider(name = "areaData")
    public Object[][] areaData() {
        return new Object[][]{
            {10.0, 5.0, 25.0},
            {5.0, 5.0, 12.5},
            {8.0, 3.0, 12.0},
            {0.0, 5.0, 0.0}
        };
    }

    @Test(dataProvider = "areaData")
    public void testCalculateAreaParameterized(double base, double height, double expected) {
        assertEquals(TriangleArea.calculateArea(base, height), expected, 0.001);
    }
}