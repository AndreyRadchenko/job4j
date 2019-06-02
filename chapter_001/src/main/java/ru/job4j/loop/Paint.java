package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Программа для построения пирамиды в псевдографике
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 30.05.2019
 * @version 2.0
 */
public class Paint {

    /**
     * Строит правую часть пирамиды
     * @param height Высота пирамиды
     * @return Результат
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column);
    }

    /**
     * Строит левую часть пирамиды
     * @param height Высота пирамиды
     * @return Результат
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1);
    }
    /**
     * Строит пирамиду заданной высоты
     * @param  height Высота пирамиды
     * @return Пирамида
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column);
    }

    /**
     * Метод принимает на вход 3 параметра
     * @param height Высота пирамиды
     * @param widht Ширина пирамиды
     * @param predict условие проставление галки
     * @return Результат
     */
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
