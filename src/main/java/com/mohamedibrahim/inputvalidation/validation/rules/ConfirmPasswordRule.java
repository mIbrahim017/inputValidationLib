package com.mohamedibrahim.inputvalidation.validation.rules;

import com.mohamedibrahim.inputvalidationlib.IValidator;

/**
 * Created by mohamed.ibrahim on 7/20/2016.
 */

public class ConfirmPasswordRule implements IValidator {
    private final String password2;

    public ConfirmPasswordRule(String password2) {
        this.password2 = password2;
    }

    @Override
    public boolean validateValue(String password1) {
        return password1.trim().equals(password2.trim());
    }

    @Override
    public boolean isResId() {
        return false;
    }

    @Override
    public int getErrorMessageId() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return "password doesn't match";
    }
}
