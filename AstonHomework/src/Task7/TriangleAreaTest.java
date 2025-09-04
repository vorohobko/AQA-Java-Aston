package Task7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    @Test
    @DisplayName("с полож. числами")
    void testTriangleAreaWithPositiveNumbers() {
        assertEquals(25.0, TriangleArea.calculateArea(10, 5));
    }

    @Test
    @DisplayName("С отриц. чилами")
    void testTriangleAreaWithNegativeNumbers() {
        assertEquals(-25.0, TriangleArea.calculateArea(10, -5));
    }

    @Test
    @DisplayName("С дробным числом")
    void testTriangleAreaWithDecimalNumbers() {
        assertEquals(12.5, TriangleArea.calculateArea(5, 5));
        assertEquals(3.75, TriangleArea.calculateArea(2.5, 3));
    }

    @Test
    @DisplayName("С нулевым знач.")
    void testTriangleAreaWithZeroHeight() {
        assertEquals(0.0, TriangleArea.calculateArea(10, 0));
    }

    @Test
    @DisplayName("С нулевым знач.")
    void testTriangleAreaWithZeroBase() {
        assertEquals(0.0, TriangleArea.calculateArea(0, 10));
    }

    @ParameterizedTest
    @DisplayName("Параметризованный тест площади треугольника")
    @CsvSource({
        "10, 5, 25.0",
        "5, 5, 12.5",
        "8, 3, 12.0",
        "0, 5, 0.0",
        "7, 0, 0.0"
    })
    void testTriangleAreaParameterized(double base, double height, double expected) {
        assertEquals(expected, TriangleArea.calculateArea(base, height), 0.001);
    }
}