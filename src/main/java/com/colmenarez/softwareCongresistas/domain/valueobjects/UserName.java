package com.colmenarez.softwareCongresistas.domain.valueobjects;

import com.colmenarez.softwareCongresistas.domain.exceptions.InvalidUserNameException;
import java.util.Objects;
import java.util.regex.Pattern;

public record UserName(String value) {

    private static final Pattern NAME_PATTERN =
            Pattern.compile("^[\\p{L} \\-']+$");
    public UserName {
        final String normalizedValue = Objects.requireNonNull(value, "UserName cannot be null")
                .trim();
        validateNotEmpty(normalizedValue);
        validateCharacters(normalizedValue);
        value = normalizedValue;
    }
    private static void validateNotEmpty(final String normalizedValue) {
        if (normalizedValue.isEmpty()) {
            throw InvalidUserNameException.empty();
        }
    }
    private static void validateCharacters(final String normalizedValue) {
        if (!NAME_PATTERN.matcher(normalizedValue).matches()) {
            throw InvalidUserNameException.invalidCharacters(normalizedValue);
        }
    }
    @Override
    public String toString() {
        return value;
    }
}