package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Test
 * @author Andrey Radchenko (radchenko@yandex.ru)
 * @since 28.05.2019
 * @version 1.0
 */
public class TriangleTest {

    /**
     * Тест вычисляем площадь треугольника
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point f = new Point(0, 0);
        Point s = new Point(0, 2);
        Point t = new Point(2, 0);
        // Создаем объект треугольник.
        Triangle triangle = new Triangle(f, s, t);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
}
