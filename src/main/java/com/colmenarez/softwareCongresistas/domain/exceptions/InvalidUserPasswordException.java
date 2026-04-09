package com.colmenarez.softwareCongresistas.domain.exceptions;

public final class InvalidUserPasswordException extends DomainException {
    private InvalidUserPasswordException(String message) {
        super(message);
    }
    public static InvalidUserPasswordException of(String reason) {
        return new InvalidUserPasswordException("User password " + reason);
    }
}
