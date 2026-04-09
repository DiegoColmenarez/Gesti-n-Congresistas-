package com.colmenarez.softwareCongresistas.domain.exceptions;

public final class InvalidUserNameException extends DomainException {

    private InvalidUserNameException(String message) {
        super(message);
    }

    public static InvalidUserNameException empty() {
        return new InvalidUserNameException("User name cannot be empty");
    }

    public static InvalidUserNameException invalidCharacters(String attemptedValue) {
        return new InvalidUserNameException(
                "User name contains invalid characters. Only letters, spaces, hyphens and apostrophes are allowed"
        );
    }
}
