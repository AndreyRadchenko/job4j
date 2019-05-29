package ru.job4j.loop;

/**
 * Программа вычисляет факториал натурального числа
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 29.05.2019
 * @version 1.0
 */
public class Factorial {

    /**
     * Вычисляет факториал
     * @param n натуральное число
     * @return Результат
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i < n + 1; i++) {
            result *= i;
        }
        return result;
    }
}
