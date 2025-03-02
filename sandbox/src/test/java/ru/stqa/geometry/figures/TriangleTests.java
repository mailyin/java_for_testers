package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(21.400000000000002, Triangle.perimeter(5.4, 8.3, 7.7));
    }

    @Test
    void canCalculateArea() {
        Assertions.assertEquals(20.20673155163893, Triangle.area(5.4, 8.3, 7.7));
    }
}
