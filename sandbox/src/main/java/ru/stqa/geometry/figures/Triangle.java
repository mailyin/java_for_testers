package ru.stqa.geometry.figures;

public record Triangle(double side1, double side2, double side3) {

    public static void printTrianglePerimeter(Triangle exampleTriangle) {
        String text = String.format("Периметр треугольника со сторонами %.1f, %.1f и %.1f = %.1f", exampleTriangle.side1, exampleTriangle.side2, exampleTriangle.side3, exampleTriangle.perimeter());
        System.out.println(text);
    }
    public double perimeter() {
        return this.side1 + this.side2 + this.side3;
    }


    public static void printTriangleArea(Triangle exampleTriangle) {
        String text = String.format("Площадь треугольника со сторонами %.1f, %.1f и %.1f = %.1f", exampleTriangle.side1, exampleTriangle.side2, exampleTriangle.side3, exampleTriangle.area());
        System.out.println(text);
    }

    public double area() {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p-side1) * (p-side2) * (p-side3));
    }
}