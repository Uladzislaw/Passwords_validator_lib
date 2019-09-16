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
    private Integer sequentialLetter;
    private Integer sequentialNumbers;

    public Integer getNumberOfCharacters() {
        return numberOfCharacters;
    }

    public void setNumberOfCharacters(final Integer numberOfCharacters) {
        this.numberOfCharacters = numberOfCharacters;
    }

    public Integer getUpperCaseLetters() {
        return upperCaseLetters;
    }

    public void setUpperCaseLetters(final Integer upperCaseLetters) {
        this.upperCaseLetters = upperCaseLetters;
    }

    public Integer getLowerCaseLetters() {
        return lowerCaseLetters;
    }

    public void setLowerCaseLetters(final Integer lowerCaseLetters) {
        this.lowerCaseLetters = lowerCaseLetters;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(final Integer numbers) {
        this.numbers = numbers;
    }

    public Integer getSymbols() {
        return symbols;
    }

    public void setSymbols(final Integer symbols) {
        this.symbols = symbols;
    }

    public Integer getRequirements() {
        return requirements;
    }

    public void setRequirements(final Integer requirements) {
        this.requirements = requirements;
    }

    public Boolean getLettersOnly() {
        return isLettersOnly;
    }

    public void setLettersOnly(final Boolean lettersOnly) {
        isLettersOnly = lettersOnly;
    }

    public Boolean getNumbersOnly() {
        return isNumbersOnly;
    }

    public void setNumbersOnly(final Boolean numbersOnly) {
        isNumbersOnly = numbersOnly;
    }

    public Integer getCaseInsensitiveRepeatChars() {
        return caseInsensitiveRepeatChars;
    }

    public void setCaseInsensitiveRepeatChars(final Integer caseInsensitiveRepeatChars) {
        this.caseInsensitiveRepeatChars = caseInsensitiveRepeatChars;
    }

    public Integer getConsecutiveUpperCaseLetters() {
        return consecutiveUpperCaseLetters;
    }

    public void setConsecutiveUpperCaseLetters(final Integer consecutiveUpperCaseLetters) {
        this.consecutiveUpperCaseLetters = consecutiveUpperCaseLetters;
    }

    public Integer getConsecutiveLowerCaseLetters() {
        return consecutiveLowerCaseLetters;
    }

    public void setConsecutiveLowerCaseLetters(final Integer consecutiveLowerCaseLetters) {
        this.consecutiveLowerCaseLetters = consecutiveLowerCaseLetters;
    }

    public Integer getConsecutiveNumbers() {
        return consecutiveNumbers;
    }

    public void setConsecutiveNumbers(final Integer consecutiveNumbers) {
        this.consecutiveNumbers = consecutiveNumbers;
    }

    public Integer getSequentialLetter() {
        return sequentialLetter;
    }

    public void setSequentialLetter(final Integer sequentialLetter) {
        this.sequentialLetter = sequentialLetter;
    }
}
