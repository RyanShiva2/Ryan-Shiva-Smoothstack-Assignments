import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /*  Assignment 3
        Create a Shape Interface with the methods "calculateArea" and "display". Create a Rectangle, Circle, and Triangle class to implement that interface.*/

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>(Arrays.asList(new Rectangle(5, 6), new Circle(7), new Triangle(9, 3)));

        for (Shape shape : shapes) {
            shape.display();
            shape.calculateArea();
            System.out.println();
        }
    }
}
