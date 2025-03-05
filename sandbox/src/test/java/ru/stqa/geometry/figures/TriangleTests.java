package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(21.400000000000002, new Triangle(5.4, 8.3, 7.7).perimeter());
    }

    @Test
    void canCalculateArea() {
        Assertions.assertEquals(20.20673155163893, new Triangle(5.4, 8.3, 7.7).area());
    }
}
