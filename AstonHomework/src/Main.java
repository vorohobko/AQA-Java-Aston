import Task7.Factorial;
import Task7.TriangleArea;
import Task7.ArithmeticOperations;
import Task7.Comparison;

public class Main {
    public static void main(String[] args) {
        // Задание 1 
    	System.out.println(" ПЕРВОЕ ");
        System.out.println(Factorial.getFactorial(4) - Factorial.getFactorial(2));
        
        // Задание 2 
        System.out.println(" -- ЗАДАНИЕ 2 -- ");
        TriangleArea triangleArea = new TriangleArea();
        double base = 10;
        double height = 5;
        double area = triangleArea.calculateArea(base, height);
        System.out.println("Площадь треугольника: " + area); 
    
        //Задание 3
        System.out.println(" -- ЗАДАНИЕ 3 -- ");
        ArithmeticOperations.arithmeticOperations(2, 2);
        
        //Задание 4
        System.out.println(" -- ЗАДАНИЕ 4 -- ");
        Comparison.comparison(10, 7);
    }
}