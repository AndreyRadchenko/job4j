package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Andrey Radchenko (radchenko@yandex.ru)
 * @since 28.05.2019
 * @version 1.0
 */
public class MultiMaxTest {

    /**
     * Тест. Первое число(3) больше
     */
    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(3, 1, 2);
        assertThat(result, is(3));
    }

    /**
     * Тест. Второе число(4) больше
     */
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    /**
     * Тест. Третье число(4) больше
     */
    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 1, 2);
        assertThat(result, is(2));
    }

    /**
     * Тест. Все числа одинаковые
     */
    @Test
    public void whenAllNumbersIsSame() {
        MultiMax check = new MultiMax();
        int result = check.max(3, 3, 3);
        assertThat(result, is(3));
    }
}