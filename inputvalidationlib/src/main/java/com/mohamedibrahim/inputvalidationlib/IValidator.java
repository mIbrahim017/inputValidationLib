package com.mohamedibrahim.inputvalidationlib;

/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */

public interface IValidator {

    boolean validateValue(String value);

    boolean isResId();

    int getErrorMessageId();

    String getErrorMessage();

}
