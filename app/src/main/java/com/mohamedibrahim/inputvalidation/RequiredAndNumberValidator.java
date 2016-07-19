package com.mohamedibrahim.inputvalidation;

import android.text.TextUtils;

import com.mohamedibrahim.inputvalidationlib.IValidator;

/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */
public class RequiredAndNumberValidator implements IValidator {
    @Override
    public boolean validateValue(String value) {
        return !TextUtils.isEmpty(value) && value.trim().length() > 0 && TextUtils.isDigitsOnly(value);
    }

    @Override
    public boolean isResId() {
        return true;
    }

    @Override
    public int getErrorMessageId() {
        return R.string.required_number_validation;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
