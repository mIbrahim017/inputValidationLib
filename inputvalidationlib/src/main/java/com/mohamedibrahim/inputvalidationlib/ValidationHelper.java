package com.mohamedibrahim.inputvalidationlib;

import android.text.TextUtils;

/**
 * Created by mohamed.ibrahim on 7/18/2016.
 */

public final class ValidationHelper {
    private ValidationHelper() {
        /**
         no constructor
         */
    }

    private static final String NOT_EMPTY = "@\"^(?!\\s*$).+\"";
    private static final String NUMBER_ONLY = "[0-9]+";


    public static boolean isEmpty(String what) {
        return TextUtils.isEmpty(what);
    }

    public static boolean isNumber(String what) {
        return !TextUtils.isEmpty(what) && TextUtils.isDigitsOnly(what);
    }

}
