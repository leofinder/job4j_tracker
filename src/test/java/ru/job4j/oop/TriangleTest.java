package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl).isCloseTo(8, offset(0.001));
    }

    @Test
    public void when00and03and06ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        Point c = new Point(0, 6);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl).isEqualTo(-1);
    }
}