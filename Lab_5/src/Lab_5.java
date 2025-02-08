class Complex {

    private double realPart;
    private double imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void add(Complex c) {
        this.realPart += c.getRealPart();
        this.imaginaryPart += c.getImaginaryPart();
    }

    public void subtract(Complex c) {
        this.realPart -= c.getRealPart();
        this.imaginaryPart -= c.getImaginaryPart();
    }

    public void print() {
        System.out.printf("(%.1f, %.1f)%n", realPart, imaginaryPart);
    }
}

public class Lab_5 {
    public static void main(String[] args) {
        Complex c1 = new Complex(2.0, 5.0); // 2.0 + 5.0i
        Complex c2 = new Complex(-3.1, -6.3); // -3.1 - 6.3i

        // Adding c2 to c1
        c1.add(c2); // c1 is now -1.1 - 1.3i
        c1.print();

        // Subtracting c1 from c2
        c2.subtract(c1);
        c2.print();
    }
}
