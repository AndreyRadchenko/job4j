package ru.job4j.loop;

/**
 * Программа для построения шахматной доски в псевдографике
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 30.05.2019
 * @version 1.0
 */
public class Board {

    /**
     * Строит строковую таблицу по заданным параметрам
     * @param width Символов по ширине
     * @param height Символов по высоте
     * @return Псевдографика
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                  if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
             screen.append(ln);
        }
        return screen.toString();
    }

}
