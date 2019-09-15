package com.wladislove.password_validator.validator.calculator.model;

public class PasswordStatistics {
    private boolean isLowerAndUpper;
    private boolean isFiguresAndNums;
    private int maxCaseInsensitiveSequence;
    private int numsQuantity;
    private int signsQuantity;


    public boolean isLowerAndUpper() {
        return isLowerAndUpper;
    }

    public void setLowerAndUpper(final boolean lowerAndUpper) {
        isLowerAndUpper = lowerAndUpper;
    }

    public boolean isFiguresAndNums() {
        return isFiguresAndNums;
    }

    public void setFiguresAndNums(final boolean figuresAndNums) {
        isFiguresAndNums = figuresAndNums;
    }

    public int getMaxCaseInsensitiveSequence() {
        return maxCaseInsensitiveSequence;
    }

    public void setMaxCaseInsensitiveSequence(final int maxCaseInsensitiveSequence) {
        this.maxCaseInsensitiveSequence = maxCaseInsensitiveSequence;
    }

    public int getNumsQuantity() {
        return numsQuantity;
    }

    public void setNumsQuantity(final int numsQuantity) {
        this.numsQuantity = numsQuantity;
    }

    public int getSignsQuantity() {
        return signsQuantity;
    }

    public void setSignsQuantity(final int signsQuantity) {
        this.signsQuantity = signsQuantity;
    }
}
