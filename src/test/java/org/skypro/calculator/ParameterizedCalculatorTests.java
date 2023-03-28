package org.skypro.calculator;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.skypro.calculator.service.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {CalculatorServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class ParameterizedCalculatorTests {

    @Autowired
    CalculatorServiceImpl calculatorService;

    private static Stream<Arguments> numsForTests() {
        return Stream.of(
                Arguments.of(10, 5),
                Arguments.of(8, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("numsForTests")
    void parameterizedTestPlus(Integer num1, Integer num2) {
        calculatorService = new CalculatorServiceImpl();
        Integer result = num1 + num2;
        String text = String.format("%s + %s = %s", num1, num2, result);
        assertEquals(calculatorService.plus(num1, num2), text);
    }

    @ParameterizedTest
    @MethodSource("numsForTests")
    void parameterizedTestMinus(Integer num1, Integer num2) {
        calculatorService = new CalculatorServiceImpl();
        Integer result = num1 - num2;
        String text = String.format("%s - %s = %s", num1, num2, result);
        assertEquals(calculatorService.minus(num1, num2), text);
    }

    @ParameterizedTest()
    @MethodSource("numsForTests")
    void parameterizedTestMultiply(Integer num1, Integer num2) {
        calculatorService = new CalculatorServiceImpl();
        Integer result = num1 * num2;
        String text = String.format("%s * %s = %s", num1, num2, result);
        assertEquals(calculatorService.multiply(num1, num2), text);
    }

    @ParameterizedTest()
    @MethodSource("numsForTests")
    void parameterizedTestDivide(Integer num1, Integer num2) {
        calculatorService = new CalculatorServiceImpl();
        Integer result = num1 / num2;
        String text = String.format("%s / %s = %s", num1, num2, result);
        assertEquals(calculatorService.divide(num1, num2), text);
    }

}
