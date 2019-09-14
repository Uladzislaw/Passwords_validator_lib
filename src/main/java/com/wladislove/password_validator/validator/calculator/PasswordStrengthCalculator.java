package com.wladislove.password_validator.validator.calculator;

import com.wladislove.password_validator.validator.calculator.model.PasswordWrapper;

import static java.util.Objects.nonNull;

public abstract class PasswordStrengthCalculator {

    private PasswordStrengthCalculator nextStrengthCalculator;
    private PasswordWrapper password;


    public abstract void calculate(final PasswordWrapper password);

    protected void next() {
        if (nonNull(nextStrengthCalculator)) {
            nextStrengthCalculator.calculate(password);
        }
    }
}
