package ru.job4j.array;

/**
 * Проверка диагоналей на идентичность элементов
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 04.06.2019
 * @version 3.0
 */
public class MatrixCheck {

    /**
     * Проверяет по очереди 2 диагонали
     * @param data Входящий массив
     * @return Результат проверки
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;

        for (int j = 1; j < data.length; j++) {

            if(data[0][0] != data[j][j]) {

                result = false;

                break;

            }
            if (data[0][data.length - 1] != data[j][data.length - j - 1]) {

                result = false;

                break;
            }

        }
        return result;
    }
}
