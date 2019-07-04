package ru.job4j.condition;

/**
 * Программа вычисляет максимальное из двух чисел
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 04.07.2019
 * @version 3.0
 */
public class Max {

    /**
     * Сравнивает 2 числа и возвращает максимальное из них
     * @param first Первое число
     * @param second Второе число
     * @return Результат
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Сравнивает 3 числа и возвращает максимальное из них
     * @param first Первое число
     * @param second Второе число
     * @param third Третье число
     * @return Результат
     */
    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    /**
     * Сравнивает 4 числа и возвращает максимальное из них
     * @param first Первое число
     * @param second Второе число
     * @param third Третье число
     * @param  fourth Четвёртое число
     * @return Результат
     */
    public int max(int first, int second, int third, int fourth) {
        return max(first, max(second, third, fourth));
    }
}
