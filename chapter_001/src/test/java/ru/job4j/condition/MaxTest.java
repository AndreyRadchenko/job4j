package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Andrey Radchenko (radchenko@yandex.ru)
 * @since 27.05.2019
 * @version 1.0
 */
public class MaxTest {

    /**
     * Тест. Первое чило больше
     */
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Тест. Второе чило больше
     */
    @Test
    public void whenMax3To1Then3() {
        Max max = new Max();
        int result = max.max(3, 1);
        assertThat(result, is(3));
    }

    /**
     * Тест. Числа одинаковые
     */
    @Test
    public void when2To2Then2() {
        Max max = new Max();
        int result = max.max(2, 2);
        assertThat(result, is(2));
    }

    /**
     * Тест. Максимальное из 3 чисел
     */
    @Test
    public void whenMax1To2To3Then3() {
        Max max = new Max();
        int result = max.max(1, 2, 3);
        assertThat(result, is(3));
    }

    /**
     * Тест. Максимальное из 3 чисел
     */
    @Test
    public void whenMax1To3To4To2Then4() {
        Max max = new Max();
        int result = max.max(1, 2, 3, 4);
        assertThat(result, is(4));
    }
}