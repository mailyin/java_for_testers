package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
class TriangleTests {

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(21.400000000000002, new Triangle(5.4, 8.3, 7.7).perimeter());
    }

    @Test
    void canCalculateArea() {
        Assertions.assertEquals(20.20673155163893, new Triangle(5.4, 8.3, 7.7).area());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(5.0, -4.8, 6.9);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void cannotCreateTriangleWithIncorrectSide() {
        try {
            new Triangle(5.0, 6.0, 1.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }
}