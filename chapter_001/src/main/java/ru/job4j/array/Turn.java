package ru.job4j.array;

/**
 * Программа для переворота массива
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 03.06.2019
 * @version 1.0
 */
public class Turn {

    /**
     * Переворачивает массив
     * @param array Переданный массив
     * @return Перевёрнутый массив
     */
    public int[] back(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

}
