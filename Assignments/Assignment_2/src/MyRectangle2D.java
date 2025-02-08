/**
 * Name: Abhijeet Singh
 * Student ID: 1207508
 * Assignment Number: 2
 * Question Number: 3
 *
 * Description:
 * This program defines the MyRectangle2D class to represent rectangles with properties
 * such as position, width, and height. It provides methods for calculating area, perimeter,
 * checking point containment, rectangle containment, and rectangle overlaps.
 *
 * How to Run:
 * - Compile the program using `javac MyRectangle2D.java`
 * - Run the test program with `java MyRectangle2D`
 * - The program demonstrates operations with predefined rectangles.
 */

public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;


    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }


    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public double getArea() {
        return width * height;
    }


    public double getPerimeter() {
        return 2 * (width + height);
    }


    public boolean contains(double x, double y) {
        return (x > this.x - width / 2 && x < this.x + width / 2 &&
                y > this.y - height / 2 && y < this.y + height / 2);
    }

    // Check if a rectangle is completely inside this rectangle
    public boolean contains(MyRectangle2D r) {
        return (r.getX() - r.getWidth() / 2 >= this.x - this.width / 2 &&
                r.getX() + r.getWidth() / 2 <= this.x + this.width / 2 &&
                r.getY() - r.getHeight() / 2 >= this.y - this.height / 2 &&
                r.getY() + r.getHeight() / 2 <= this.y + this.height / 2);
    }

    // Check if a rectangle overlaps with this rectangle
    public boolean overlaps(MyRectangle2D r) {
        return !(r.getX() - r.getWidth() / 2 >= this.x + this.width / 2 ||
                r.getX() + r.getWidth() / 2 <= this.x - this.width / 2 ||
                r.getY() - r.getHeight() / 2 >= this.y + this.height / 2 ||
                r.getY() + r.getHeight() / 2 <= this.y - this.height / 2);
    }

    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());

        System.out.println("Contains point (3, 3): " + r1.contains(3, 3));
        System.out.println("Contains rectangle (4, 5, 10.5, 3.2): " + r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
        System.out.println("Overlaps rectangle (3, 5, 2.3, 5.4): " + r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }
}
