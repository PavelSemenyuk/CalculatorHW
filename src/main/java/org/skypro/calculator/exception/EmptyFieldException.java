package org.skypro.calculator.exception;

public class EmptyFieldException extends IllegalArgumentException {
    public EmptyFieldException(String message) {
        super(message);
    }
}
