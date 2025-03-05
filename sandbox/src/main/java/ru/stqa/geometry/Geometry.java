package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.2));
        Square.printSquareArea(new Square(3.6));
        System.out.println("");
        Rectangle.printRectangleArea(3.8, 5.4);
        Rectangle.printRectangleArea(3.2, 5.9);
        System.out.println("");
        Triangle.printTrianglePerimeter(new Triangle(5.8, 4.9, 5.1));
        Triangle.printTrianglePerimeter(new Triangle(2.6, 3.2, 3.4));
        Triangle.printTriangleArea(new Triangle(5.8, 4.7, 6.3));
        Triangle.printTriangleArea(new Triangle(2.6, 3.2, 3.4));
    }

}
