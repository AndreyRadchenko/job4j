package ru.job4j.array;

/**
 * Проверка диагоналей на идентичность элементов
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 04.06.2019
 * @version 1.0
 */
public class MatrixCheck {

    /**
     * Проверяет по очереди 2 диагонали
     * @param data Входящий массив
     * @return Результат проверки
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int i = 0;
        for (int j = 0; j < data.length - 1; j++) {
            if (data[i][j] != data[i + 1][j + 1]) {
                result = false;
                break;
            }
            i++;
        }

        i = 0;
        for (int j = data.length - 1; j > 0; j--) {
            if (data[i][j] != data[i + 1][j - 1]) {
                result = false;
                break;
            }
            i++;
        }
        return result;
    }
}
