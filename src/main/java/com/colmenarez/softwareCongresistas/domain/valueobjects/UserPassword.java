package com.colmenarez.softwareCongresistas.domain.valueobjects;

import com.colmenarez.softwareCongresistas.domain.exceptions.InvalidUserPasswordException;
import java.util.Objects;
import java.util.regex.Pattern;

public record UserPassword(String value) {
    private static final Pattern VALID_PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,128}$");
    public UserPassword {
        Objects.requireNonNull(value, "UserPassword cannot be null");

        if (value.isEmpty()) {
            throw InvalidUserPasswordException.of("cannot be empty");
        }

        if (value.contains(" ")) {
            throw InvalidUserPasswordException.of("cannot contain whitespace");
        }
        if (!VALID_PASSWORD_PATTERN.matcher(value).matches()) {
            throw InvalidUserPasswordException.of(
                    "must be 8-128 chars with uppercase, lowercase, digit and special char (@$!%*?&)"
            );
        }

        value = value;
    }

    @Override
    public String toString() {
        return "[PROTECTED]";
    }
}