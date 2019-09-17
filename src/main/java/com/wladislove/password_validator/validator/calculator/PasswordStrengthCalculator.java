package com.wladislove.password_validator.validator.calculator;


import com.wladislove.password_validator.analysis.PasswordAnalizator;
import com.wladislove.password_validator.validator.calculator.model.PasswordStatistics;

public class PasswordStrengthCalculator {

    public Long calculate(final String password, final int minLen, final int maxLen) {
        if (!checkLength(password, minLen, maxLen)) {
            return 0L;
        }
        int len = password.length();
        PasswordStatistics statistics = new PasswordAnalizator()
                .gatherStatistics(password);
        long additions = (long) (statistics.getNumberOfCharacters() * 4)
                + (statistics.getNumbers() * 4)
                + (statistics.getSymbols() * 6);
        if (statistics.getUpperCaseLetters() > 0) {
            additions += (len - statistics.getUpperCaseLetters()) * 2;
        }
        if (statistics.getLowerCaseLetters() > 0) {
            additions += (len - statistics.getLowerCaseLetters()) * 2;
        }
        if (statistics.getRequirements() > 3) {
            additions += statistics.getRequirements() * 2;
        }
        long deductions = 0;
        if (statistics.getLettersOnly()) {
            deductions += len;
        } else if (statistics.getNumbersOnly()) {
            deductions += len;
        }
        deductions += statistics.getCaseInsensitiveRepeatChars()
                + (statistics.getConsecutiveUpperCaseLetters() * 2)
                + (statistics.getConsecutiveLowerCaseLetters() * 2)
                + (statistics.getConsecutiveNumbers() * 2);
        return additions - deductions;
    }

    private boolean checkLength(final String password,
                                final int min, final int max) {
        return min <= password.length() && max >= password.length();
    }
}
