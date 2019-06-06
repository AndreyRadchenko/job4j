package ru.job4j.array;

import java.util.Arrays;

/**
 * Удаление дубликатов из массива
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 06.06.2019
 * @version 1.0
 */
public class ArrayDuplicate {

    /**
     * Сортирует дубликаты в конец массив и отрезезает их
     * @param array Входящий массив с дубликатами
     * @return Массив без дубликатов
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[--unique];
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
