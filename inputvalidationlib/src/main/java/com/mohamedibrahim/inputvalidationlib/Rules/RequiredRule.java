package com.mohamedibrahim.inputvalidationlib.Rules;

import android.text.TextUtils;

import com.mohamedibrahim.inputvalidationlib.IValidator;


/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */

public class RequiredRule implements IValidator {
    @Override
    public boolean validateValue(String value) {
        return !TextUtils.isEmpty(value) && value.trim().length() > 0;
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
        return "Field is required";
    }
}
