package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Geometry {
    public static void main(String[] args) {
        Supplier<Square> randomSqaure = () -> new Square(new Random().nextDouble(100.0));
        var squares = Stream.generate(randomSqaure).limit(5);
        squares.peek(Square::printSquareArea).forEach(Square::printSquarePerimeter);



//        System.out.println("");
//
//        Rectangle.printRectangleArea(3.8, 5.4);
//        Rectangle.printRectangleArea(3.2, 5.9);
//        System.out.println("");
//
//        Triangle.printTrianglePerimeter(new Triangle(5.8, 4.9, 5.1));
//        Triangle.printTrianglePerimeter(new Triangle(2.6, 3.2, 3.4));
//        Triangle.printTriangleArea(new Triangle(5.8, 4.7, 6.3));
//        Triangle.printTriangleArea(new Triangle(2.6, 3.2, 3.4));
    }

}
