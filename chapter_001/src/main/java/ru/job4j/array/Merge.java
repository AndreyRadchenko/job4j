package ru.job4j.array;

/**
 * Объединение 2х массивов и сортировка
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 11.06.2019
 * @version 1.0
 */
public class Merge {

    /**
     * Объединяет 2 массива и сортирует результат
     * @param left первый массив
     * @param right второй массив
     * @return объеденённый массив
     */
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        for (int i = 0; i < left.length; i++) {
            rsl[i] = left[i];
        }
        for (int i = 0; i < right.length; i++) {
            rsl[left.length + i] = right[i];
        }
        BubbleSort rslt = new BubbleSort();
        rsl = rslt.sort(rsl);
        return rsl;
    }
}
