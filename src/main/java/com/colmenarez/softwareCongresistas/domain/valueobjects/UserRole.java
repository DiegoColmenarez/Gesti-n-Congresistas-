package com.colmenarez.softwareCongresistas.domain.valueobjects;

import com.colmenarez.softwareCongresistas.domain.enums.UserTypeRole;
import com.colmenarez.softwareCongresistas.domain.exceptions.InvalidUserRoleException;
public record UserRole(UserTypeRole value) {
    public UserRole {
        if (value == null) {
            throw InvalidUserRoleException.nullValue();
        }
    }
    @Override
    public String toString() {
        return value.name();
    }
}