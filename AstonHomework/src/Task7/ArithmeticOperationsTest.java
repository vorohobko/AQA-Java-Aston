package Task7;

import org.testng.annotations.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.testng.Assert.*;

public class ArithmeticOperationsTest {

    @Test
    public void testArithmeticOperationsPositiveNumbers() {
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
    public void testArithmeticOperationsDivisionByZero() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ArithmeticOperations.arithmeticOperations(10, 0);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains("Деление на ноль невозможно"));
    }
}