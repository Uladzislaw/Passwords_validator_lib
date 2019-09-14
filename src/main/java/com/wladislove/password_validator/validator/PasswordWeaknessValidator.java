package com.wladislove.password_validator.validator;

import com.wladislove.password_validator.annotation.PasswordMatches;
import com.wladislove.password_validator.annotation.PasswordWeakness;
import com.wladislove.password_validator.annotation.PasswordWeakness.PasswordStrength;
import com.wladislove.password_validator.validator.calculator.DevilStrengthCalculator;
import com.wladislove.password_validator.validator.calculator.HardStrengthCalculator;
import com.wladislove.password_validator.validator.calculator.MediumStrengthCalculator;
import com.wladislove.password_validator.validator.calculator.PasswordStrengthCalculator;
import com.wladislove.password_validator.validator.calculator.WeakStrengthCalculator;
import com.wladislove.password_validator.validator.calculator.model.PasswordWrapper;

import static com.wladislove.password_validator.reflection.util.ReflectionUtil.accessFieldAndGet;

class PasswordWeaknessValidator {

    boolean calcPasswordStrength(final Class<?> cl, final Object o) {
        if (cl.isAnnotationPresent(PasswordWeakness.class)) {
            PasswordMatches passwordMatches = cl.getAnnotation(PasswordMatches.class);
            PasswordWeakness passwordWeakness = cl.getAnnotation(PasswordWeakness.class);
            PasswordWrapper passwordWrapper
                    = new PasswordWrapper(accessFieldAndGet(passwordMatches.password(), cl, o),
                    passwordWeakness.minSymbols(), passwordWeakness.maxSymbols());
            PasswordStrength strength = passwordWeakness.strength();
            PasswordStrengthCalculator strengthCalculator = new WeakStrengthCalculator();
            switch (strength) {
                case MEDIUM:
                    setMediumLevel(strengthCalculator);
                    break;
                case HARD:
                    setHardLevel(strengthCalculator);
                    break;
                case DEVIL:
                    setDevilLevel(strengthCalculator);
                    break;
            }
            strengthCalculator.calculate(passwordWrapper);
            return true;
        }
        throw new IllegalArgumentException("Annotations wasn't found.");
    }

    private void setMediumLevel(final PasswordStrengthCalculator strengthCalculator) {
        strengthCalculator.setNextStrengthCalculator(new MediumStrengthCalculator());
    }

    private void setHardLevel(final PasswordStrengthCalculator strengthCalculator) {
        setMediumLevel(strengthCalculator);
        strengthCalculator.setNextStrengthCalculator(new HardStrengthCalculator());
    }

    private void setDevilLevel(final PasswordStrengthCalculator strengthCalculator) {
        setHardLevel(strengthCalculator);
        strengthCalculator.setNextStrengthCalculator(new DevilStrengthCalculator());
    }
}
