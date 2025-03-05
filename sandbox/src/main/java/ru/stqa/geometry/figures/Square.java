package ru.stqa.geometry.figures;

public record Square(double side) {

    public static void printSquareArea(Square g) {
        String text = String.format("Площадь квадрата со стороной %.1f = %.1f", g.side, g.area());
         System.out.println(text);
    }

    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return 4 * this.side;
    }
}
