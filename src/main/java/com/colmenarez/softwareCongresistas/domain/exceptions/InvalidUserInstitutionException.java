package com.colmenarez.softwareCongresistas.domain.exceptions;

public final class InvalidUserInstitutionException extends DomainException {

    private InvalidUserInstitutionException(String message) {
        super(message);
    }
    public static InvalidUserInstitutionException empty() {
        return new InvalidUserInstitutionException("User institution cannot be empty");
    }
    public static InvalidUserInstitutionException tooLong(int maxLength, int actualLength) {
        return new InvalidUserInstitutionException(
                "User institution exceeds maximum length of %d characters".formatted(maxLength)
        );
    }
    public static InvalidUserInstitutionException invalidCharacters(String attemptedValue) {
        return new InvalidUserInstitutionException(
                "User institution contains invalid characters"
        );
    }
}