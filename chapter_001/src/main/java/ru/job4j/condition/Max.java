package ru.job4j.condition;

/**
 * Программа вычисляет максимальное из двух чисел
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 27.05.2019
 * @version 1.0
 */
public class Max {

    /**
     * Сравнивает числа и возвращает максимальное из них
     * @param first Первое число
     * @param second Второе число
     * @return Результат
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
