package ru.job4j.array;

/**
 * Программа для возведения элементов массива в квадрат
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 03.06.2019
 * @version 1.0
 */
public class Square {

    /**
     * Принимает на вход размер массива и возводит каждый элемент в квадрат
     * @param bound Размер массива
     * @return Результат
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);  // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат

        }
        return rst;
    }
}
