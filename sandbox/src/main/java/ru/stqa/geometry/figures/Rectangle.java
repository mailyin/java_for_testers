package ru.stqa.geometry.figures;

public class Rectangle {
     public static void printRectangleArea(double b, double c) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", b, c, rectangleArea(b, c));
         System.out.println(text);
    }

    private static double rectangleArea(double b, double c) {
        return b * c;
    }
}
