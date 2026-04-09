package com.colmenarez.softwareCongresistas.domain.exceptions;

public final class InvalidUserLastNameException extends DomainException {
    private InvalidUserLastNameException(String message) {
        super(message);
    }
    public static InvalidUserLastNameException empty() {
        return new InvalidUserLastNameException("User last name cannot be empty");
    }
    public static InvalidUserLastNameException invalidCharacters(String attemptedValue) {
        return new InvalidUserLastNameException(
                "User last name contains invalid characters. Only letters, spaces, hyphens and apostrophes are allowed"
        );
    }
}