package Task7;

public class ArithmeticOperations {
    public static void arithmeticOperations(int a, int b) {
        System.out.println("Результат сложения: " + (a + b));
        System.out.println("Результат вычитания: " + (a - b));
        
        if (b != 0) {
            System.out.println("Результат деления: " + (a / b));
        } else {
            System.out.println("Делить на 0 нельзя!!");
        }
        
        System.out.println("Результат умножения: " + (a * b));
    }
}