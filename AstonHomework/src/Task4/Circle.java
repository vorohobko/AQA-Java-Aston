package Task4;

public class Circle implements GeometricShape {
    private double radius;
    private String fillColor;
    private String borderColor;
    
    public Circle(double radius) {
        this.radius = radius;
        this.fillColor = "белый";
        this.borderColor = "черный";
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
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
    
    public double getRadius() {
        return radius;
    }
}