package com.alura.tech.exceptions;

public class InvalidAddressException extends Exception {
    public InvalidAddressException() {
        super();
    }

    public InvalidAddressException(String message) {
        super(message);
    }
}
