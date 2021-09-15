public class Rectangle implements Shape {

    private int length;
    private int height;

    public Rectangle(int length, int height) {
        this.length = length;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void display() {
        System.out.println("Display a rectangle with a length of " + length + " and a height of " + height);
    }

    @Override
    public void calculateArea() {
        System.out.println("The area of the rectangle is " + length * height);
    }
}
