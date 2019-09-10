package com.wladislove.password_validator.validator;

import com.wladislove.password_validator.annotation.PasswordMatches;
import com.wladislove.password_validator.exception.PasswordsDontMatchException;

import java.lang.reflect.Field;

import static java.util.Objects.requireNonNull;

public class PasswordValidator {

    private static PasswordValidator validator = new PasswordValidator();


    public static void validateObjectsPasswordsOrElseThrow(final Object object) {
        if (!validator.validatePassMatching(requireNonNull(object).getClass(), object)) {
            throw new PasswordsDontMatchException("Passwords don't match.");
        }
    }

    public static boolean validateObjectsPasswords(final Object object) {
        return validator.validatePassMatching(requireNonNull(object).getClass(), object);
    }

    private boolean validatePassMatching(final Class<?> cl, final Object o) {
        if (cl.isAnnotationPresent(PasswordMatches.class)) {
            PasswordMatches passwordMatches = cl.getAnnotation(PasswordMatches.class);
            String password = accessFieldAndGet(passwordMatches.password(), cl, o);
            String matchingPassword = accessFieldAndGet(passwordMatches.matchingPassword(), cl, o);
            return password.equals(matchingPassword);
        }
        throw new IllegalArgumentException("Annotations wasn't found.");
    }

    private String accessFieldAndGet(final String fieldName,
                                     final Class<?> cl,
                                     final Object o) {
        try {
            Field passwordField = cl.getDeclaredField(fieldName);
            passwordField.setAccessible(true);
            return (String) passwordField.get(o);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(
                    "Field with " + fieldName + " wasn't found.");
        }
    }

}
