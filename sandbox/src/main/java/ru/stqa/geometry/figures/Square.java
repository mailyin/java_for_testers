package ru.stqa.geometry.figures;

public record Square(double side) {

    public Square {
        if (side < 0) {
            throw new IllegalArgumentException("Square side should be non-negative");
        }
    }

    public static void printSquareArea(Square g) {
        String text = String.format("Площадь квадрата со стороной %.1f = %.1f", g.side, g.area());
         System.out.println(text);
    }

    public static void printSquarePerimeter(Square g) {
        String text = String.format("Периметр квадрата со стороной %.1f = %.1f", g.side, g.perimeter());
        System.out.println(text);
    }

    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
}
