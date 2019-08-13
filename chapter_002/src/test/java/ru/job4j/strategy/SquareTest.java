package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Andrey Radchenko (radchenko@yandex.ru)
 * @since 12.08.2019
 * @version 1.0
 */
public class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("+++++++")
                                .append(System.lineSeparator())
                                .append("+     +")
                                .append(System.lineSeparator())
                                .append("+     +")
                                .append(System.lineSeparator())
                                .append("+++++++")
                                .toString()
                )
        );
    }

}