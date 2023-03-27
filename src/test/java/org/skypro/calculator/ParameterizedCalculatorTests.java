package org.skypro.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.skypro.calculator.service.CalculatorService;
import org.skypro.calculator.service.CalculatorServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedCalculatorTests {

    private CalculatorService calculatorService;

    private static Stream<Arguments> numsForTests() {
        return Stream.of(
                Arguments.of(10, 5),
                Arguments.of(8, 2)
        );
    }

    @ParameterizedTest()
    @MethodSource("numsForTests")
    void ParameterizedTestPlus(Integer num1, Integer num2) {
        calculatorService = new CalculatorServiceImpl();
        Integer result = num1 + num2;
        String text = String.format("%s + %s = %s", num1, num2, result);
        assertEquals(calculatorService.plus(num1, num2), text);
    }

    @ParameterizedTest()
    @MethodSource("numsForTests")
    void ParameterizedTestMinus(Integer num1, Integer num2) {
        calculatorService = new CalculatorServiceImpl();
        Integer result = num1 - num2;
        String text = String.format("%s - %s = %s", num1, num2, result);
        assertEquals(calculatorService.minus(num1, num2), text);
    }

    @ParameterizedTest()
    @MethodSource("numsForTests")
    void ParameterizedTestMultiply(Integer num1, Integer num2) {
        calculatorService = new CalculatorServiceImpl();
        Integer result = num1 * num2;
        String text = String.format("%s * %s = %s", num1, num2, result);
        assertEquals(calculatorService.multiply(num1, num2), text);
    }

    @ParameterizedTest()
    @MethodSource("numsForTests")
    void ParameterizedTestDivide(Integer num1, Integer num2) {
        calculatorService = new CalculatorServiceImpl();
        Integer result = num1 / num2;
        String text = String.format("%s / %s = %s", num1, num2, result);
        assertEquals(calculatorService.divide(num1, num2), text);
    }

}
