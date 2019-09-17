package com.wladislove.password_validator.analysis;

import com.wladislove.password_validator.validator.calculator.model.PasswordStatistics;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class PasswordAnalizator {

    public PasswordStatistics gatherStatistics(final String password) {
        PasswordStatistics statistics = new PasswordStatistics();
        statistics.setLettersOnly(password.chars().allMatch(Character::isLetter));
        statistics.setNumbersOnly(password.chars().allMatch(Character::isDigit));
        statistics.setCaseInsensitiveRepeatChars(calcCaseInsensitiveRepeatChars(password));
        statistics.setConsecutiveUpperCaseLetters(calcConsecutiveUpperCaseLetters(password));
        statistics.setConsecutiveLowerCaseLetters(calcConsecutiveLowerCaseLetters(password));
        statistics.setConsecutiveNumbers(calcConsecutiveNumbers(password));
        statistics.setNumberOfCharacters(password.length());
        statistics.setUpperCaseLetters((int) password.chars().filter(Character::isUpperCase).count());
        statistics.setLowerCaseLetters((int) password.chars().filter(Character::isLowerCase).count());
        statistics.setNumbers((int) password.chars().filter(Character::isDigit).count());
        statistics.setSymbols((int) password.chars().filter(PasswordAnalizator::isSymbol).count());
        statistics.setRequirements(calcPointByRequirements(password));
        return statistics;
    }

    private int calcCaseInsensitiveRepeatChars(final String password) {
        char[] chars = password.toCharArray();
        int result = 0;
        List<Character> calculatedChars = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (calculatedChars.contains(aChar)) {
                continue;
            }
            for (int j = i + 1; j < chars.length; j++) {
                if (aChar == chars[j]) {
                    ++result;
                    calculatedChars.add(aChar);
                }
            }
        }
        return result * 2;
    }

    private int calcConsecutiveNumbers(final String password) {
        char[] chars = password.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            boolean isFirst;
            if (isDigit(chars[i])) { //if digit character - step forward to next digit
                i++;
                isFirst = true;
                while (i < chars.length && isDigit(chars[i])) {
                    if (isFirst) {
                        result += 1;
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

    private static boolean isSymbol(final int c) {
        return !(isLetter(c) || isDigit(c));
    }

    private int calcConsecutiveUpperCaseLetters(final String password) {
        char[] chars = password.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            boolean isFirst;
            if (isUpperCase(chars[i])) { //if uppers case - step forward to next letter
                i++;
                isFirst = true;
                while (i < chars.length && isUpperCase(chars[i])) {
                    if (isFirst) {
                        result += 1;
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

    private int calcConsecutiveLowerCaseLetters(final String password) {
        char[] chars = password.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            boolean isFirst;
            if (isLowerCase(chars[i])) { //if lower case - step forward to next letter
                i++;
                isFirst = true;
                while (i < chars.length && isLowerCase(chars[i])) {
                    if (isFirst) {
                        result += 1;
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

    private int calcPointByRequirements(final String password) {
        int result = 0;
        if (password.matches(".*[A-Z].*")) {
            ++result;
        }
        if (password.matches(".*[a-z].*")) {
            ++result;
        }
        if (password.matches(".*\\d.*")) {
            ++result;
        }
        if (password.length() >= 8) {
            ++result;
        }
        if (password.chars().filter(PasswordAnalizator::isSymbol).count() >= 1) {
            ++result;
        }
        return result;
    }
}
