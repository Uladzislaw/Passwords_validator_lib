package com.wladislove.password_validator.validator.calculator;

import com.wladislove.password_validator.validator.calculator.model.PasswordStatistics;
import com.wladislove.password_validator.validator.calculator.model.PasswordWrapper;

import static java.util.Objects.nonNull;

public abstract class PasswordStrengthCalculator {

    private PasswordStrengthCalculator nextStrengthCalculator;


    public abstract void calculate(final PasswordWrapper password);

    protected void calculate(final PasswordWrapper password,
                                      final PasswordStatistics statistics) {
        throw new UnsupportedOperationException("Operation is not supported by this class");
    }

    protected void next(final PasswordWrapper password) {
        if (nonNull(nextStrengthCalculator)) {
            nextStrengthCalculator.calculate(password);
        }
    }

    protected void next(final PasswordWrapper password,
                        final PasswordStatistics statistics) {
        if (nonNull(nextStrengthCalculator)) {
            nextStrengthCalculator.calculate(password, statistics);
        }
    }

    public void setNextStrengthCalculator(final PasswordStrengthCalculator nextStrengthCalculator) {
        this.nextStrengthCalculator = nextStrengthCalculator;
    }
}
