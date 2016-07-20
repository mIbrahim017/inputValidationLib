package com.mohamedibrahim.inputvalidation.validation.rules;

import android.text.TextUtils;

import com.mohamedibrahim.inputvalidationlib.IValidator;

/**
 * Created by mohamed.ibrahim on 7/20/2016.
 */

public class EmailRule implements IValidator {
    @Override
    public boolean validateValue(String value) {
        return !TextUtils.isEmpty(value) && value.trim().contains("@");
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
        return "invalid user E-mail";
    }
}
