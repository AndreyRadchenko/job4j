package ru.job4j.array;

/**
 * Таблица умножения
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 04.06.2019
 * @version 1.0
 */
public class Matrix {

    /**
     * Создаёт таблицу умножения размером до передаваемого числа
     * @param size Размер матрицы
     * @return Таблица умножения
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        return table;
    }
}
