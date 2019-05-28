package ru.job4j.condition;

/**
 * Программа вычисляет максимальное из трёх чисел
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 28.05.2019
 * @version 1.0
 */
public class MultiMax {
    /**
     * Сравнивает числа и возвращает максимальное из них
     * @param first Первое число
     * @param second Второе число
     * @param third Третье число
     * @return Результат
     */
    public int max(int first, int second, int third) {

        int result = second > third ? second : third;
        result = result > first ? result : first;

        return result;
    }
}
