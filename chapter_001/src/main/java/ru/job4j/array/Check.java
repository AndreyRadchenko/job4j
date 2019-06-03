package ru.job4j.array;

/**
 * Программа для проверки идентичности элементов
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 03.06.2019
 * @version 1.0
 */
public class Check {

    /**
     * Проверяет все элементы массива на идентичность
     * @param data Входящий массив
     * @return Результат
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == data[i + 1]) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
