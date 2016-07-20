package com.mohamedibrahim.inputvalidation.SimpleForm;

import android.text.TextUtils;
import android.view.View;

import com.mohamedibrahim.inputvalidation.R;
import com.mohamedibrahim.inputvalidationlib.BaseUIValidation;

/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */

class UIValidation extends BaseUIValidation {


    String getTitleError() {
        if (isTitle() && !TextUtils.isEmpty(getErrorMessage())) return getErrorMessage();
        return "";
    }

    String getBodyError() {
        if (isBody() && !TextUtils.isEmpty(getErrorMessage())) return getErrorMessage();
        return "";
    }

    String getPhoneError() {
        if (isPhone() && !TextUtils.isEmpty(getErrorMessage())) return getErrorMessage();
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


    private boolean isTitle() {
        return getViewId() == R.id.edTitle;
    }

    private boolean isPhone() {
        return getViewId() == R.id.edPhone;
    }

    private boolean isBody() {
        return getViewId() == R.id.edBody;
    }


}
