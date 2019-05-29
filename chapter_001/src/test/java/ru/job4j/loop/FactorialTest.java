package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test
 * @author Andrey Radchenko (radchenko@yandex.ru)
 * @since 29.05.2019
 * @version 1.0
 */
public class FactorialTest {

    /**
     * Тест. Передаём число 5
     */
    @Test
    public void calcFactFive() {
        Factorial num = new Factorial();
        int result = num.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Тест. Передаём число 0
     */
    @Test
    public void calcFactZero() {
        Factorial num = new Factorial();
        int result = num.calc(0);
        assertThat(result, is(1));
    }

}