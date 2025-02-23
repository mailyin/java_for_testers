package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(7.3);
        Square.printSquareArea(5.2);
        Square.printSquareArea(3.6);

        Rectangle.printRectangleArea(3.8, 5.4);
        Rectangle.printRectangleArea(3.2, 5.9);
    }

}
