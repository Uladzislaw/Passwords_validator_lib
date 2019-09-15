package com.wladislove.password_validator.validator.calculator.model;

public class PasswordStatistics {
    private Integer numberOfCharacters;
    private Integer upperCaseLetters;
    private Integer lowerCaseLetters;
    private Integer numbers;
    private Integer symbols;
    private Integer requirements;

    private Boolean isLettersOnly;
    private Boolean isNumbersOnly;
    private Integer caseInsensitiveRepeatChars;
    private Integer consecutiveUpperCaseLetters;
    private Integer consecutiveLowerCaseLetters;
    private Integer consecutiveNumbers;
}
