package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Test
 * @author Radchenko Andrey
 * @since 27.05.2019
 * @version 1.0
 */
public class SqAreaTest {

    /**
     * Тест 1 периметр прямоугольника в площадь
     */
    @Test
    public void p4k1s1() {
        assertThat(new SqArea().square(4, 1), is(1));
    }

    /**
     * Тест 2 периметр прямоугольника в площадь
     */
    @Test
    public void p6k2s2() {
        assertThat(new SqArea().square(6, 2), is(2));
    }
}