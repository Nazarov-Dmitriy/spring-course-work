package ru.netology.coursework.exception;

public class ErrorTransfer extends RuntimeException {
    public ErrorTransfer(String message) {
        super(message);
    }
}
