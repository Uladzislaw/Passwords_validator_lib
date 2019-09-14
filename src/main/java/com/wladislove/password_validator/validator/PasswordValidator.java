package com.wladislove.password_validator.validator;

import com.wladislove.password_validator.exception.PasswordsDontMatchException;
import com.wladislove.password_validator.exception.WeakPasswordException;

import static java.util.Objects.requireNonNull;

public class PasswordValidator {

    private static PasswordMatcherValidator passwordMatcherValidator
            = new PasswordMatcherValidator();
    private static PasswordWeaknessValidator passwordWeaknessValidator
            = new PasswordWeaknessValidator();


    public static void validateObjectsPasswordsOrElseThrow(final Object object) {
        if (!passwordMatcherValidator
                .validatePassMatching(requireNonNull(object).getClass(), object)) {
            throw new PasswordsDontMatchException("Passwords don't match.");
        }
        if (!passwordWeaknessValidator
                .calcPasswordStrength(object.getClass(), object)) {
            throw new WeakPasswordException("Password too weak.");
        }
    }

    public static boolean validateObjectsPasswords(final Object object) {
        return passwordMatcherValidator
                .validatePassMatching(requireNonNull(object).getClass(), object);
    }
}
