package com.mohamedibrahim.inputvalidationlib.Rules;

import android.text.TextUtils;


/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */

public class NumberRule extends BaseRule {


    public NumberRule() {
        super("input must be number only");
    }

    @Override
    public boolean validateValue(String value) {
        return !TextUtils.isEmpty(value) && TextUtils.isDigitsOnly(value);

    }

}
