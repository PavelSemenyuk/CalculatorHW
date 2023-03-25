package org.skypro.calculator.service;

import org.skypro.calculator.exception.EmptyFieldException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public void isZero(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            throw new EmptyFieldException("На ноль делить нельзя!");
        }
    }

    public void isNull(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new NullPointerException("Пустое значение недопустимо");
        }
    }

    @Override
    public String plus(Integer num1, Integer num2) {
        isNull(num1, num2);
        int result = num1 + num2;
        return num1 + " + " + num2 + " = " + result;
    }

    @Override
    public String minus(Integer num1, Integer num2) {
        isNull(num1, num2);
        int result = num1 - num2;
        return num1 + " - " + num2 + " = " + result;
    }

    @Override
    public String multiply(Integer num1, Integer num2) {
        isNull(num1, num2);
        int result = num1 * num2;
        return num1 + " * " + num2 + " = " + result;

    }

    @Override
    public String divide(Integer num1, Integer num2) {
        isNull(num1, num2);
        isZero(num1, num2);
        int result = num1 / num2;
        return num1 + " / " + num2 + " = " + result;

    }


}
