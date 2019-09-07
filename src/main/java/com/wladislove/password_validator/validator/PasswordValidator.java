package com.wladislove.password_validator.validator;

import com.wladislove.password_validator.annotation.PasswordMatches;

import static java.util.Objects.requireNonNull;

public class PasswordValidator {

    private static PasswordValidator validator = new PasswordValidator();

    public static void validateObjectsPasswords(final Object object) {
        requireNonNull(object);
        validator.validatePassMatching(object.getClass());
    }

    private void validatePassMatching(final Class<?> obj) {
        if (obj.isAnnotationPresent(PasswordMatches.class)) {
            PasswordMatches passwordMatches = obj.getAnnotation(PasswordMatches.class);

        }
    }
}
