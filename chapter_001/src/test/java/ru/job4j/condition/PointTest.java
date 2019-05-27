package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Radchenko Andrey
 * @since 27.05.2019
 * @version 1.0
 */
public class PointTest {

    /**
     * Тест расчёт расстояния между точками в системе координат
     */
    @Test
    public void whenZeroAndTenThenTen() {
        Point point = new Point();
        double result = point.distance(0, 0, 0, 10);
        assertThat(result, is(10D));
    }
}