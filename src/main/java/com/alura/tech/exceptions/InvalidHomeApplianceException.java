package com.alura.tech.exceptions;

public class InvalidHomeApplianceException extends Exception {
    public InvalidHomeApplianceException() {
        super();
    }
    public InvalidHomeApplianceException(String message) {
        super(message);
    }
}
