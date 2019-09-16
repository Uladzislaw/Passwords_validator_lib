package com.wladislove.password_validator.analysis;

import com.wladislove.password_validator.validator.calculator.model.PasswordStatistics;

import static java.lang.Character.isUpperCase;

public class PasswordAnalizator {
    public PasswordStatistics gatherStatistics(final String password) {
        PasswordStatistics statistics = new PasswordStatistics();
        statistics.setLettersOnly(password.chars().allMatch(Character::isLetter));
        statistics.setNumbersOnly(password.chars().allMatch(Character::isAlphabetic));
        statistics.setNumberOfCharacters((int)password.chars().distinct().count());
        statistics.setConsecutiveUpperCaseLetters(calcConsecutiveUpperCaseLetters(password));
        return statistics;
    }

    public int calcConsecutiveUpperCaseLetters(final String password) {
        char[] chars = password.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            boolean isFirst = false;
            if (isUpperCase(chars[i])) {
                i++;
                isFirst = true;
                while (i < chars.length && isUpperCase(chars[i])) {
                    if (isFirst) {
                        result += 2;
                        isFirst = false;
                    } else {
                        result++;
                    }
                    i++;
                }
            }
        }
        return result;
    }
}
