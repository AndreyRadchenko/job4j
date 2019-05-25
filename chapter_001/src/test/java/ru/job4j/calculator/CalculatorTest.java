package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Radchenko Andrey
 * @since 16.05.2019
 * @version 1.0
 */
public class CalculatorTest  {
    /**
     * Тест сложения
     */
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Тест вычитания
     */
    @Test
    public void whenAddTwoMinusOneThenOne()  {
        Calculator calc = new Calculator();
        double result = calc.subtract(2D, 1D);
        double expected = 1D;
        assertThat(result, is(expected));
    }
    /**
     * Тест деления
     */
    @Test
    public void whenAddSixDivideThreeThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.div(6D, 3D);
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Тест умножения
     */
    @Test
    public void whenAddTwoMultiplyThreeThenSix()  {
        Calculator calc = new Calculator();
        double result = calc.multiple(2D, 3D);
        double expected = 6D;
        assertThat(result, is(expected));
    }
}