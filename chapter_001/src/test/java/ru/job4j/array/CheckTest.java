package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Andrey Radchenko (radchenko@yandex.ru)
 * @since 03.06.2019
 * @version 1.0
 */
public class CheckTest {

    /**
     * Тест. Передаём однородный массив с нечётным количеством элементов
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Тест. Передаём неоднородный массив с чётным количеством элементов
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}