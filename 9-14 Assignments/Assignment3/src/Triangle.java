public class Triangle implements Shape {
    private int base;
    private int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void display() {
        System.out.println("Display a triangle with a base of " + base + " and a height of " + height);
    }

    @Override
    public void calculateArea() {
        System.out.println("The area of the triangle is " + (base * height) / 2.0);
    }
}
