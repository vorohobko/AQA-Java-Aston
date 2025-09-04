package Task7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ComparisonTest {

    @Test
    @DisplayName("Если a > b")
    void testComparisonWhenAGreaterThanB() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Comparison.comparison(10, 5);

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("Число а больше, чем b"));
        assertFalse(output.contains("Число b больше, чем а"));
    }

    @Test
    @DisplayName("Если b > a")
    void testComparisonWhenBGreaterThanA() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Comparison.comparison(5, 10);

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("Число b больше, чем а"));
        assertFalse(output.contains("Число а больше, чем b"));
    }

    @Test
    @DisplayName("Если a = b")
    void testComparisonWhenAEqualsB() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Comparison.comparison(5, 5);

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("Число b больше, чем а"));
        assertFalse(output.contains("Число а больше, чем b"));
    }

    @Test
    @DisplayName("Тест с отрицательными числами")
    void testComparisonWithNegativeNumbers() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Comparison.comparison(-5, -10);

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("Число а больше чем b"));
    }
    
    @ParameterizedTest
    @CsvSource({
        "10, 5, 'Число a больше чем b'",
        "5, 10, 'Число b больше чем a'",
        "5, 5, 'Числа a и b равны'",
        "-5, -10, 'Число a больше чем b'",
        "0, 5, 'Число b больше чем a'"
    })
    void testComparisonParameterized(int a, int b, String expectedOutput) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Comparison.comparison(a, b);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains(expectedOutput));
    }
}