package com.wladislove.password_validator.validator.calculator;

import com.wladislove.password_validator.exception.WeakPasswordException;
import com.wladislove.password_validator.validator.calculator.model.PasswordWrapper;

public class WeakStrengthCalculator extends PasswordStrengthCalculator {
    @Override
    public void calculate(final PasswordWrapper password) {
        if (checkLength(password)) {
            next();
            return;
        }
        throw new WeakPasswordException("Password length is invalid.");
    }

    private boolean checkLength(final PasswordWrapper password) {
        return password.getMinLen() <= password.getPassword().length()
                && password.getMaxLen() >= password.getPassword().length();
    }
}
