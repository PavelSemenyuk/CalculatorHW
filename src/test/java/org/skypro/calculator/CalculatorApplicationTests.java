package org.skypro.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.calculator.exception.EmptyFieldException;
import org.skypro.calculator.service.CalculatorService;
import org.skypro.calculator.service.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



class CalculatorApplicationTests {

    private CalculatorService calculatorService;

    @BeforeEach
    public void test() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void testPlus() {
        String text = "3 + 2 = 5";
        assertEquals(calculatorService.plus(3, 2), text);
    }

    @Test
    public void testPlus2() {
        String text = "9 + 1 = 10";
        assertEquals(calculatorService.plus(9, 1), text);
    }

    @Test
    public void testMinus() {
        String text = "3 - 2 = 1";
        assertEquals(calculatorService.minus(3, 2), text);
    }

    @Test
    public void testMinus2() {
        String text = "11 - 1 = 10";
        assertEquals(calculatorService.minus(11, 1), text);
    }

    @Test
    public void testMultiply() {
        String text = "3 * 2 = 6";
        assertEquals(calculatorService.multiply(3, 2), text);
    }

    @Test
    public void testMultiply2() {
        String text = "5 * 5 = 25";
        assertEquals(calculatorService.multiply(5, 5), text);
    }

    @Test
    public void testDivide() {
        String text = "6 / 2 = 3";
        assertEquals(calculatorService.divide(6, 2), text);
    }

    @Test
    public void testDivide2() {
        String text = "12 / 2 = 6";
        assertEquals(calculatorService.divide(12, 2), text);
    }

    @Test
    public void testDivideWillThrowExceptionWhenDivideOnZero() {
        assertThrows(EmptyFieldException.class,
                () -> {
                    calculatorService.divide(1, 0);
                });
    }

    @Test
    public void testDivideWillThrowExceptionWhenDivideOnNull() {
        assertThrows(NullPointerException.class,
                () -> {
                    calculatorService.divide(null, null);
                });
    }

}
