package com.mohamedibrahim.inputvalidation.Login;

import com.mohamedibrahim.inputvalidation.R;
import com.mohamedibrahim.inputvalidationlib.BaseUIValidation;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by mohamed.ibrahim on 7/20/2016.
 */

public class LoginUIValidation extends BaseUIValidation {


    public String getPasswordErrorMessage() {
        return isValidationForPassword() ? getErrorMessage() : "";

    }


    public int getPasswordVisibility() {
        return isValidationForPassword() ? VISIBLE : GONE;
    }

    public int getMailViewVisibility() {
        return isValidationForMail() ? VISIBLE : GONE;

    }


    public String getMailError() {
        return isValidationForMail() ? getErrorMessage() : null;
    }

    public String getPasswordError() {
        return isValidationForPassword() ? getErrorMessage() : null;

    }

    public String getMailErrorMessage() {
        return isValidationForMail() ? getErrorMessage() : "";
    }


    private boolean isValidationForPassword() {
        return getViewId() == R.id.edPassword;
    }

    private boolean isValidationForMail() {
        return getViewId() == R.id.edMail;
    }
}
