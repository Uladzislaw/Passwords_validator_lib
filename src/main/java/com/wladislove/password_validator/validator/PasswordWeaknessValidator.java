package com.wladislove.password_validator.validator;

import com.wladislove.password_validator.annotation.PasswordMatches;
import com.wladislove.password_validator.annotation.PasswordWeakness;
import com.wladislove.password_validator.annotation.PasswordWeakness.PasswordStrength;
import com.wladislove.password_validator.validator.calculator.PasswordStrengthCalculator;

import static com.wladislove.password_validator.reflection.util.ReflectionUtil.accessFieldAndGet;

class PasswordWeaknessValidator {

    boolean calcPasswordStrength(final Class<?> cl, final Object o) {
        if (cl.isAnnotationPresent(PasswordWeakness.class)) {
            PasswordMatches passwordMatches = cl.getAnnotation(PasswordMatches.class);
            PasswordWeakness passwordWeakness = cl.getAnnotation(PasswordWeakness.class);
            String password = accessFieldAndGet(passwordMatches.password(), cl, o);
            PasswordStrength strength = passwordWeakness.strength();
            Long passwordStrength = new PasswordStrengthCalculator()
                    .calculate(password, passwordWeakness.minSymbols(),
                            passwordWeakness.maxSymbols());
            return (strength.equals(PasswordStrength.WEAK) && passwordStrength > 0)
                    || (strength.equals(PasswordStrength.MEDIUM) && passwordStrength >= 35)
                    || (strength.equals(PasswordStrength.HARD) && passwordStrength >= 70)
                    || (strength.equals(PasswordStrength.DEVIL) && passwordStrength >= 80);
        }
        return true;
    }
}