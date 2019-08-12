package ru.job4j.strategy;

/**
 * Вывод заданной формы в консоль
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 12.08.2019
 * @version 1.0
 */
public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

}
