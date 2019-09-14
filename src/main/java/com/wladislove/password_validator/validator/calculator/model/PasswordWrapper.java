package com.wladislove.password_validator.validator.calculator.model;

public class PasswordWrapper {
    private String password;
    private int minLen;
    private int maxLen;

    public PasswordWrapper(final String password, final int minLen, final int maxLen) {
        this.password = password;
        this.minLen = minLen;
        this.maxLen = maxLen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public int getMinLen() {
        return minLen;
    }

    public void setMinLen(final int minLen) {
        this.minLen = minLen;
    }

    public int getMaxLen() {
        return maxLen;
    }

    public void setMaxLen(final int maxLen) {
        this.maxLen = maxLen;
    }
}
