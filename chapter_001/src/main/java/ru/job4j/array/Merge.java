package ru.job4j.array;

import java.util.Arrays;

/**
 * Объединение 2х массивов в порядке сортировки
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 11.06.2019
 * @version 2.0
 */
public class Merge {

    /**
     * Объединяет 2 массива в порядке сортировки
     * @param left первый массив
     * @param right второй массив
     * @return объеденённый массив
     */
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        if (rsl.length == left.length) {
            rsl = Arrays.copyOf(left, left.length);
        } else if (rsl.length == right.length) {
            rsl = Arrays.copyOf(right, right.length);
        } else {
            int j = 0;
            int g = 0;
            for (int i = 0; i < rsl.length; i++) {
                if (left[j] < right[g]) {
                    rsl[i] = left[j];
                    if (j == left.length - 1) {
                        while (g < right.length) {
                            rsl[++i] = right[g++];
                        }
                        break;
                    }
                    j++;
                } else {
                    rsl[i] = right[g];
                    if (g == right.length - 1) {
                        while (j < left.length) {
                            rsl[++i] = left[j++];
                        }
                        break;
                    }
                    g++;
                }
            }
        }
        return rsl;
    }
}
