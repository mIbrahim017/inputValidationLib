package com.mohamedibrahim.inputvalidation.Registration;

import com.mohamedibrahim.inputvalidation.R;
import com.mohamedibrahim.inputvalidationlib.BaseUIValidation;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by mohamed.ibrahim on 7/20/2016.
 */

public class RegisterUIValidation extends BaseUIValidation {


    public int getPasswordVisibility() {
        return isValidationForPassword() ? VISIBLE : GONE;
    }

    public int getMailViewVisibility() {
        return isValidationForMail() ? VISIBLE : GONE;
    }

    public int getConfirmVisibility() {
        return isValidationForConfirm() ? VISIBLE : GONE;
    }


    public String getMailError() {
        return getErrorMessage(isValidationForMail());
    }

    public String getPasswordError() {
        return getErrorMessage(isValidationForPassword());

    }

    public String getConfirmPasswordError() {
        return getErrorMessage(isValidationForConfirm());

    }


    private String getErrorMessage(boolean b) {
        return b ? getErrorMessage() : null;
    }


    private boolean isValidationForPassword() {
        return getViewId() == R.id.edPassword;
    }

    private boolean isValidationForMail() {
        return getViewId() == R.id.edMail;
    }

    private boolean isValidationForConfirm() {
        return getViewId() == R.id.edConfirm;
    }
}
