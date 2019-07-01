package ru.job4j.condition;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Программа расчёта расстояния между двумя точками в плоской системе координат
 */
public class Point {

    /**
     * Расчёт расстояния по формуле
     * @param x1 Координата x первой точки
     * @param y1 Координата x первой точки
     * @param x2 Координата x первой точки
     * @param y2 Координата x первой точки
     * @return Расстояние.
     */
    public double distance(int x1, int y1, int x2, int y2) {

        return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    }
}