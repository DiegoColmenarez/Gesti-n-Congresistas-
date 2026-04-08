package com.colmenarez.softwareCongresistas.domain.valueobjects;

import com.colmenarez.softwareCongresistas.domain.exceptions.InvalidUserEmailException;
import java.util.Objects;
import java.util.regex.Pattern;

public record UserEmail(String value) {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[a-zA-Z0-9._%+\\-]+@[a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}$");
    public UserEmail {
        final String normalizedValue = Objects.requireNonNull(value, "UserEmail cannot be null")
                .trim()
                .toLowerCase();
        validateNotEmpty(normalizedValue);
        validateFormat(normalizedValue);
        value = normalizedValue;
    }
    private static void validateNotEmpty(final String normalizedValue) {
        if (normalizedValue.isEmpty()) {
            throw InvalidUserEmailException.empty();
        }
    }
    private static void validateFormat(final String normalizedValue) {
        if (!EMAIL_PATTERN.matcher(normalizedValue).matches()) {
            throw InvalidUserEmailException.invalidFormat(normalizedValue);
        }
    }
    @Override
    public String toString() {
        return value;
    }
}