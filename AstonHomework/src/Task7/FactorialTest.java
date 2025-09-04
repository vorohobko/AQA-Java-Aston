package Task7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FactorialTest {

    @Test
    @DisplayName("Тест факториала 0")
    void testFactorialOfZero() {
        assertEquals(1, Factorial.getFactorial(0));
    }

    @Test
    @DisplayName("Тест факториала 1")
    void testFactorialOfOne() {
        assertEquals(1, Factorial.getFactorial(1));
    }

    @Test
    @DisplayName("Тест факториала 5")
    void testFactorialOfFive() {
        assertEquals(120, Factorial.getFactorial(5));
    }

    @Test
    @DisplayName("Тест факториала 10")
    void testFactorialOfTen() {
        assertEquals(3628800, Factorial.getFactorial(10));
    }

    @Test
    @DisplayName("Отриц. число")
    void testFactorialOfNegative() {
        assertEquals(1, Factorial.getFactorial(-5));
    }
    
    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "5, 120",
        "6, 720"
    })
    void testFactorialParameterized(int input, int expected) {
        assertEquals(expected, Factorial.getFactorial(input));
    }
}