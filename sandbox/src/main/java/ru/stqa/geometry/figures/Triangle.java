package ru.stqa.geometry.figures;

public class Triangle {
    public static void printTrianglePerimeter(double d, double e, double f) {
        String text = String.format("Периметр треугольника со сторонами %.1f, %.1f и %.1f = %.1f", d, e, f, trianglePerimeter(d, e, f));
        System.out.println(text);
    }
    private static double trianglePerimeter(double d, double e, double f) {
        return d + e + f;
    }


    public static void printTriangleArea(double d, double e, double f) {
        String text = String.format("Площадь треугольника со сторонами %.1f, %.1f и %.1f = %.1f", d, e, f, triangleArea(d, e, f));
        System.out.println(text);
    }
    private static double triangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p-a) * (p-b) * (p-c));
    }
}