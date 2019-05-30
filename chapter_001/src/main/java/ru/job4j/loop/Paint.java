package ru.job4j.loop;

/**
 * Программа для построения пирамиды в псевдографике
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 30.05.2019
 * @version 1.0
 */
public class Paint {

    /**
     * Строит пирамиду заданной высоты
     * @param  height Высота пирамиды
     * @return Пирамида
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int width = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
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
