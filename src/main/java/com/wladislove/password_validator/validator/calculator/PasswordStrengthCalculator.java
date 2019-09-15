package com.wladislove.password_validator.validator.calculator;


import com.wladislove.password_validator.analysis.PasswordAnalizator;
import com.wladislove.password_validator.validator.calculator.model.PasswordStatistics;

public class PasswordStrengthCalculator {

    public Long calculate(final String password, final int minLen, final int maxLen) {
        if (!checkLength(password, minLen, maxLen)) {
            return 0L;
        }
        PasswordStatistics statistics = new PasswordAnalizator()
                .gatherStatistics(password);
        return 0L;
    }

    private boolean checkLength(final String password,
                                final int min, final int max) {
        return min <= password.length() && max >= password.length();
    }
}
