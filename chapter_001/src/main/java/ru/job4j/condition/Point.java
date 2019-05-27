package ru.job4j.condition;

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
        double first = Math.pow(x2 - x1, 2);
        double second = Math.pow(y2 - y1, 2);
        return Math.sqrt(first + second);
    }
}