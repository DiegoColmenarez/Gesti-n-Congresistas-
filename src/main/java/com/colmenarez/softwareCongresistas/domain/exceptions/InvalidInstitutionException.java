package com.colmenarez.softwareCongresistas.domain.exceptions;

public class InvalidInstitutionException extends RuntimeException {
    public InvalidInstitutionException(String message) {
        super(message);
    }
}
