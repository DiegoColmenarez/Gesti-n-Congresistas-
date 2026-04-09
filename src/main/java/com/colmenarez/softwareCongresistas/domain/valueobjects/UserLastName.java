package com.colmenarez.softwareCongresistas.domain.valueobjects;

import com.colmenarez.softwareCongresistas.domain.exceptions.InvalidUserLastNameException;
import java.util.Objects;
import java.util.regex.Pattern;

public record UserLastName(String value) {
    private static final Pattern LAST_NAME_PATTERN =
            Pattern.compile("^[\\p{L} \\-']+$");
    public UserLastName {
        final String normalizedValue = Objects.requireNonNull(value, "UserLastName cannot be null")
                .trim();
        validateNotEmpty(normalizedValue);
        validateCharacters(normalizedValue);
        value = normalizedValue;
    }
    private static void validateNotEmpty(final String normalizedValue) {
        if (normalizedValue.isEmpty()) {
            throw InvalidUserLastNameException.empty();
        }
    }
    private static void validateCharacters(final String normalizedValue) {
        if (!LAST_NAME_PATTERN.matcher(normalizedValue).matches()) {
            throw InvalidUserLastNameException.invalidCharacters(normalizedValue);
        }
    }
    @Override
    public String toString() {
        return value;
    }
}