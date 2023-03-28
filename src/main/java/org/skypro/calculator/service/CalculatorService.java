package org.skypro.calculator.service;

public interface CalculatorService {

    String plus(Integer num1, Integer num2);

    String minus(Integer num1, Integer num2);

    String multiply(Integer num1, Integer num2);

    String divide(Integer num1, Integer num2);

    void isNull(Integer num1, Integer num2);

    void isZero(Integer num1, Integer num2);


}
