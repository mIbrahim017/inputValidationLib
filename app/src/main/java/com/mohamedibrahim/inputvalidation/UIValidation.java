package com.mohamedibrahim.inputvalidation;

import android.text.TextUtils;
import android.view.View;

import com.mohamedibrahim.inputvalidationlib.FieldValidator;
import com.mohamedibrahim.inputvalidationlib.IValidator;

/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */

class UIValidation {
    private int viewId;
    private String errorMessage;


    void setValidationUI(FieldValidator field, IValidator iValidator) {
        viewId = field.getControl().getId();
        errorMessage = getErrorMessage(field, iValidator);
        field.getControl().setError(errorMessage);
    }


    String getTitleError() {
        if (isTitle() && !TextUtils.isEmpty(errorMessage)) return errorMessage;
        return "";
    }

    String getBodyError() {
        if (isBody() && !TextUtils.isEmpty(errorMessage)) return errorMessage;
        return "";
    }

    String getPhoneError() {
        if (isPhone() && !TextUtils.isEmpty(errorMessage)) return errorMessage;
        return "";
    }

    int getTitleVisibility() {
        if (isTitle()) return View.VISIBLE;
        return View.GONE;
    }

    int getBodyVisibility() {
        if (isBody()) return View.VISIBLE;
        return View.GONE;
    }

    int getPhoneVisibility() {
        if (isPhone()) return View.VISIBLE;
        return View.GONE;
    }

    /**
     * helper method
     */

    private String getErrorMessage(FieldValidator field, IValidator iValidator) {
        try {
            return iValidator.isResId() ?
                    field.getControl().getContext().getString(iValidator.getErrorMessageId()) : iValidator.getErrorMessage();
        } catch (Throwable e) {
            return "";
        }
    }

    private boolean isTitle() {
        return viewId == R.id.edTitle;
    }

    private boolean isPhone() {
        return viewId == R.id.edPhone;
    }

    private boolean isBody() {
        return viewId == R.id.edBody;
    }

    public void setValidationPass() {
        viewId = -1;
        errorMessage = null;
    }
}
