package com.colmenarez.softwareCongresistas.domain.exceptions;

public final class InvalidUserRoleException extends DomainException {

    private InvalidUserRoleException(String message) {
        super(message);
    }

    public static InvalidUserRoleException nullValue() {
        return new InvalidUserRoleException("User role cannot be null");
    }
}
