package com.mohamedibrahim.inputvalidationlib.Rules;

import android.text.TextUtils;


/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */

public class RequiredRule extends BaseRule {


    public RequiredRule() {
        super("Field is required");
    }

    @Override
    public boolean validateValue(String value) {
        return !TextUtils.isEmpty(value) && value.trim().length() > 0;
    }

}
