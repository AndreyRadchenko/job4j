package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Andrey Radchenko (radchenko@yandex.ru)
 * @since 29.05.2019
 * @version 1.0
 */

public class CounterTest {

    /**
     * Тест. Диапазон от 1 до 10
     */
    @Test
    public void rangeOneToTen() {
        Counter range = new Counter();
        int result = range.add(1, 10);
        assertThat(result, is(30));
    }
}