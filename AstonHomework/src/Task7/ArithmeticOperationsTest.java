package Task7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    @DisplayName("Тест арифметических операций с положительными числами")
    void testArithmeticOperationsWithPositiveNumbers() {
        // Перехват вывода в консоль
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ArithmeticOperations.arithmeticOperations(10, 5);

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("Результат сложения: 15"));
        assertTrue(output.contains("Результат вычитания: 5"));
        assertTrue(output.contains("Результат деления: 2"));
        assertTrue(output.contains("Результат умножения: 50"));
    }

    @Test
    @DisplayName("Тестс отрицательными числами")
    void testArithmeticOperationsWithNegativeNumbers() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ArithmeticOperations.arithmeticOperations(-10, -5);

        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("Результат сложения: -15"));
        assertTrue(output.contains("Результат вычитания: -5"));
        assertTrue(output.contains("Результат деления: 2"));
        assertTrue(output.contains("Результат умножения: 50"));
    }

    @Test
    @DisplayName("Тест деления на ноль (ArithmeticException)")
    void testArithmeticOperationsDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            ArithmeticOperations.arithmeticOperations(10, 0);
        });
    }
}