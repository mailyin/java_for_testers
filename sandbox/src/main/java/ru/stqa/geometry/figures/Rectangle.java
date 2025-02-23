package ru.stqa.geometry.figures;

public class Rectangle {
     public static void printRectangleArea(double b, double c) {
        System.out.println("Площадь прямоугольника со сторонами " + b + " и " + c + " = " + rectangleArea(b, c));
    }

    private static double rectangleArea(double b, double c) {
        return b * c;
    }
}
