package ru.job4j.array;

/**
 * Программа для поиска элемента в массиве
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 03.06.2019
 * @version 1.0
 */
public class FindLoop {

    /**
     * Осуществляет поиск элемента в массиве
     * @param data Массив
     * @param el Искомый элемент
     * @return Результат поиска
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
