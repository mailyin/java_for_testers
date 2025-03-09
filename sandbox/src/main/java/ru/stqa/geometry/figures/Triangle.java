package ru.stqa.geometry.figures;

import java.util.Objects;

public record Triangle(double side1, double side2, double side3) {

    public Triangle {
        if (side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalArgumentException("Triangle inequality must be respected");
        }
    }

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(this.side1, triangle.side1) == 0 && Double.compare(this.side2, triangle.side2) == 0 && Double.compare(this.side3, triangle.side3) == 0)
                || (Double.compare(this.side1, triangle.side1) == 0 && Double.compare(this.side2, triangle.side3) == 0 && Double.compare(this.side3, triangle.side2) == 0)
                || (Double.compare(this.side1, triangle.side2) == 0 && Double.compare(this.side2, triangle.side1) == 0 && Double.compare(this.side3, triangle.side3) == 0)
                || (Double.compare(this.side1, triangle.side2) == 0 && Double.compare(this.side2, triangle.side3) == 0 && Double.compare(this.side3, triangle.side1) == 0)
                || (Double.compare(this.side1, triangle.side3) == 0 && Double.compare(this.side2, triangle.side1) == 0 && Double.compare(this.side3, triangle.side2) == 0)
                || (Double.compare(this.side1, triangle.side3) == 0 && Double.compare(this.side2, triangle.side2) == 0 && Double.compare(this.side3, triangle.side1) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}