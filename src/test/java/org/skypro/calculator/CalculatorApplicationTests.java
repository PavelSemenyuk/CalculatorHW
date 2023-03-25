package org.skypro.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.calculator.controller.CalculatorController;
import org.skypro.calculator.entity.Calculator;
import org.skypro.calculator.exception.EmptyFieldException;
import org.skypro.calculator.service.CalculatorService;
import org.skypro.calculator.service.CalculatorServiceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorApplicationTests {
    CalculatorService calculatorService;
    CalculatorController calculatorController;

    @BeforeEach
    public void test() {
        calculatorService = new CalculatorServiceImpl();
        calculatorController = new CalculatorController(calculatorService);
    }

    @Test
    public void testPlus() {
        String text = "2 + 2 = 4";
        assertEquals(calculatorController.plus(2, 2), text);
    }

    @Test
    public void testMinus() {
        String text = "3 - 2 = 1";
        assertEquals(calculatorController.minus(3, 2), text);
    }

    @Test
    public void testMultiply() {
        String text = "3 * 2 = 6";
        assertEquals(calculatorController.multiply(3, 2), text);
    }

    @Test
    public void testDivide() {
        String text = "6 / 2 = 3";
        assertEquals(calculatorController.divide(6, 2), text);
    }

    @Test
    public void testDivideWillThrowExceptionWhenDivideOnZero() {
        assertThrows(EmptyFieldException.class,
                () -> {
                    calculatorController.divide(0, 1);
                });
    }

    @Test
    public void testDivideWillThrowExceptionWhenDivideOnNull() {
        assertThrows(NullPointerException.class,
                () -> {
                    calculatorController.divide(1, null);
                });
    }

}
