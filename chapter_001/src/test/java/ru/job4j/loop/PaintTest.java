package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test
 * @author Andrey Radchenko (radchenko@yandex.ru)
 * @since 30.05.2019
 * @version 1.0
 */
public class PaintTest {

    /**
     * Тест. Строим пирамиду 4 строки высотой
     */
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rst = paint.pyramid(4);
        System.out.println(rst);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("   ^   ")
                .add("  ^^^  ")
                .add(" ^^^^^ ")
                .add("^^^^^^^")
                .toString()));
    }

}