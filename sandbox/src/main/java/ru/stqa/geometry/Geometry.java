package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(7.3);
        Square.printSquareArea(5.2);
        Square.printSquareArea(3.6);
        System.out.println("");
        Rectangle.printRectangleArea(3.8, 5.4);
        Rectangle.printRectangleArea(3.2, 5.9);
        System.out.println("");
        Triangle.printTrianglePerimeter(5.8, 4.9, 5.1);
        Triangle.printTrianglePerimeter(2.6, 3.2, 3.4);
        Triangle.printTriangleArea(5.8, 4.9, 5.1);
        Triangle.printTriangleArea(2.6, 3.2, 3.4);
    }

}
