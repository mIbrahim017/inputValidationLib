package com.mohamedibrahim.inputvalidation.validation.rules;

import android.text.TextUtils;

import com.mohamedibrahim.inputvalidationlib.IValidator;

/**
 * Created by mohamed.ibrahim on 7/20/2016.
 */

public class LoginPasswordRule implements IValidator {
    @Override
    public boolean validateValue(String value) {
        if (TextUtils.isEmpty(value)) return false;
        final int s = value.trim().length();
        return s > 6;
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
        return "Invalid password";
    }
}
