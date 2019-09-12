package com.wladislove.password_validator.validator;

import com.wladislove.password_validator.annotation.PasswordWeakness;

class PasswordWeaknessValidator {

    boolean calcPasswordStrength(final Class<?> cl, final Object o) {
        if (cl.isAnnotationPresent(PasswordWeakness.class)) {

            return true;
        }
        throw new IllegalArgumentException("Annotations wasn't found.");
    }
}
