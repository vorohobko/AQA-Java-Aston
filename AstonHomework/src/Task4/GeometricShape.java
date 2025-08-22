package Task4;

interface GeometricShape extends Colored {
    double calculatePerimeter();
    double calculateArea();
    
    // Вывод информации
    default void printInfo() {
        System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()) + 
                         ", Площадь: " + String.format("%.2f", calculateArea()) +
                         ", Цвет фона: " + getFillColor() +
                         ", Цвет границ: " + getBorderColor());
    }
}
