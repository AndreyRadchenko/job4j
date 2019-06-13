package ru.job4j.loop;

/**
 * Программа суммирует все чётные числа в диапазоне
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 29.05.2019
 * @version 1.0
 */
public class Counter {

    /**
     * Складывает чётные числа в диапазоне
     * @param start Начало диапазона
     * @param finish конец диапазона
     * @return Сумма чётных чисел в диапазоне
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (; start <= finish; start++) {
            if (start % 2 == 0) {
                sum += start;
            }
        }
        return sum;
    }
}
