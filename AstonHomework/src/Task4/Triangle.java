package Task4;

public class Triangle implements GeometricShape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;
    
    public Triangle(double sideA, double sideB, double sideC) {
        if (isValidTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        } else {
            throw new IllegalArgumentException("Невозможно создать треугольник с такими сторонами");
        }
        this.fillColor = "белый";
        this.borderColor = "черный";
    }
    
    private boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }
    
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
    
    @Override
    public double calculateArea() {
        // Используем формулу Герона
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    @Override
    public String getFillColor() {
        return fillColor;
    }
    
    @Override
    public String getBorderColor() {
        return borderColor;
    }
    
    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }
    
    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }
    
    public double getSideA() {
        return sideA;
    }
    
    public double getSideB() {
        return sideB;
    }
    
    public double getSideC() {
        return sideC;
    }
}
