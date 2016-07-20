package com.mohamedibrahim.inputvalidationlib;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by mohamed.ibrahim on 7/19/2016.
 * <p>
 * abstract layer to  Handle all validation logic.
 */
public abstract class BaseUIValidation {

    private TextView control;
    private int viewId;
    private String errorMessage;

    protected void setupValidationUI(TextView field, IValidator iValidator) {

        this.viewId = field.getId();
        this.control = field;
        this.errorMessage = getErrorMessage(field.getContext(), iValidator);

    }


    public String getErrorMessage() {
        return TextUtils.isEmpty(errorMessage) ? "" : errorMessage;
    }

    protected void setValidationPass() {
        viewId = -1;
        errorMessage = null;
    }

    private String getErrorMessage(Context context, IValidator iValidator) {
        try {
            return iValidator.isResId() ?
                    context.getString(iValidator.getErrorMessageId()) : iValidator.getErrorMessage();
        } catch (Throwable e) {
            return "";
        }
    }

    protected int getViewId() {
        return viewId;
    }


    protected TextView getControl() {
        return control;
    }
}
