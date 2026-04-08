package com.colmenarez.softwareCongresistas.domain.exceptions;

public final class InvalidUserEmailException extends DomainException {

    private InvalidUserEmailException(String message) {
        super(message);
    }
    public static InvalidUserEmailException empty() {
        return new InvalidUserEmailException("User email cannot be null or empty");
    }
    public static InvalidUserEmailException invalidFormat(String attemptedValue) {
        return new InvalidUserEmailException(
                "Invalid email format for value: '%s'".formatted(attemptedValue)
        );
    }
}