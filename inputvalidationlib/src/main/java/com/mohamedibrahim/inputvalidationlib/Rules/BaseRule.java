package com.mohamedibrahim.inputvalidationlib.Rules;

import com.mohamedibrahim.inputvalidationlib.IValidator;
import com.mohamedibrahim.inputvalidationlib.R;

import static android.text.TextUtils.isEmpty;

/**
 * Created by user on 8/5/2016.
 */
public abstract class BaseRule implements IValidator {


    protected final String DEFAULT_MESSAGE = "Invalid Validation Message";
    protected final int DEFAULT_RES_ID = R.string.default_validation;

    private final int resId;
    private final String message;
    private final boolean isFromRes;

    public BaseRule() {
        this.resId = 0;
        this.message = null;
        this.isFromRes = true;

    }


    protected BaseRule(int resId) {
        this.resId = resId;
        this.message = null;
        this.isFromRes = true;
    }

    protected BaseRule(String message) {
        this.resId = 0;
        this.message = message;
        this.isFromRes = false;
    }

    @Override
    public boolean isResId() {
        return isFromRes ;
    }

    @Override
    public int getErrorMessageId() {
        return resId > 0 ? resId : DEFAULT_RES_ID;
    }


    @Override
    public String getErrorMessage() {
        return isEmpty(message) ? DEFAULT_MESSAGE : message;
    }
}
