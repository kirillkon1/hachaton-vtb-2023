package ru.vtb.vtbbackend.exceptions;

public class BankNotFoundException extends Exception {
    public BankNotFoundException(String message) {
        super(message);
    }
}
