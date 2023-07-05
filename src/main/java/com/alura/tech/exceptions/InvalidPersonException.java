package com.alura.tech.exceptions;

public class InvalidPersonException extends Exception {

    public InvalidPersonException() {
        super();
    }

    public InvalidPersonException(String message) {
        super(message);
    }
}
