package com.wladislove.password_validator.validator;

import com.wladislove.password_validator.exception.PasswordsDontMatchException;

import static java.util.Objects.requireNonNull;

public class PasswordValidator {

    private static PasswordMatcherValidator passwordMatcherValidator
            = new PasswordMatcherValidator();


    public static void validateObjectsPasswordsOrElseThrow(final Object object) {
        if (!passwordMatcherValidator
                .validatePassMatching(requireNonNull(object).getClass(), object)) {
            throw new PasswordsDontMatchException("Passwords don't match.");
        }
    }

    public static boolean validateObjectsPasswords(final Object object) {
        return passwordMatcherValidator
                .validatePassMatching(requireNonNull(object).getClass(), object);
    }

}
