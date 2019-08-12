package ru.job4j.strategy;

/**
 * Реализация формы квадрат
 * @author Radchenko Andrey (radchenko@yandex.ru)
 * @since 12.08.2019
 * @version 1.0
 */
public class Square implements Shape {

    @Override
    public String draw() {

        StringBuilder pic = new StringBuilder();
        pic.append("+++++++");
        pic.append("+     +");
        pic.append("+     +");
        pic.append("+++++++");
        return pic.toString();
    }
}
