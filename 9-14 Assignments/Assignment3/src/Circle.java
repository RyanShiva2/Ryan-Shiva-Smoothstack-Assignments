import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void display() {
        System.out.println("Display a circle with a radius of " + radius);
    }

    @Override
    public void calculateArea() {
        System.out.println("The area of the circle is " + (new BigDecimal(Math.pow(radius, 2) * Math.PI)).setScale(2, RoundingMode.HALF_UP));
    }
}
