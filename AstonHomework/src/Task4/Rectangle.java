package Task4;

public class Rectangle implements GeometricShape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.fillColor = "белый";
        this.borderColor = "черный";
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public double calculateArea() {
        return width * height;
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
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
}
