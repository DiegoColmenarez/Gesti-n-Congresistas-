package com.colmenarez.softwareCongresistas.domain.valueobjects;

import com.colmenarez.softwareCongresistas.domain.exceptions.InvalidUserInstitutionException;
import java.util.Objects;
import java.util.regex.Pattern;

public record UserInstitution(String value) {
    private static final Pattern VALID_CHARS_PATTERN =
            Pattern.compile("^[\\p{L}0-9\\s\\-.,&()]+$");
    private static final int MAX_LENGTH = 150;
    public UserInstitution {
        final String normalizedValue = Objects.requireNonNull(value, "UserInstitution cannot be null")
                .trim()
                .replaceAll("\\s+", " ");  // Colapsa múltiples espacios en uno solo
        validateNotEmpty(normalizedValue);
        validateLength(normalizedValue);
        validateCharacters(normalizedValue);
        value = normalizedValue;
    }
    private static void validateNotEmpty(final String normalizedValue) {
        if (normalizedValue.isEmpty()) {
            throw InvalidUserInstitutionException.empty();
        }
    }
    private static void validateLength(final String normalizedValue) {
        if (normalizedValue.length() > MAX_LENGTH) {
            throw InvalidUserInstitutionException.tooLong(MAX_LENGTH, normalizedValue.length());
        }
    }
    private static void validateCharacters(final String normalizedValue) {
        if (!VALID_CHARS_PATTERN.matcher(normalizedValue).matches()) {
            throw InvalidUserInstitutionException.invalidCharacters(normalizedValue);
        }
    }
    public String toAggregationKey() {
        return value.toLowerCase();
    }
    @Override
    public String toString() {
        return value;
    }
}