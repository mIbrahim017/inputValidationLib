package com.mohamedibrahim.inputvalidationlib;


import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by mohamed.ibrahim on 7/19/2016.
 * <p>
 * abstract layer to  Handle all validation logic.
 * This class updated its fields each time the validation error happened
 */
public abstract class BaseUIValidation {


    /**
     * default values
     */
    private static final int DEFAULT_VIEW_ID = -1;
    private static final String DEFAULT_ERROR_MESSAGE = null;




    private TextView control;
    private int viewId;
    private String errorMessage;


    /**
     * update the validation fields with Control and the validation error that occurred
     *
     * @param field
     * @param iValidator
     */
    protected void updateValidationUI(TextView field, IValidator iValidator) {

        this.viewId = field.getId();
        this.control = field;
        this.errorMessage = getErrorMessage(field.getContext(), iValidator);

    }


    /**
     * @return error message if it valid string empty otherwise
     */
    public String getErrorMessage() {
        return TextUtils.isEmpty(errorMessage) ? "" : errorMessage;
    }


    /**
     * clean the fields with default values  when the valiation pass
     */
    void setValidationPass() {
        viewId = DEFAULT_VIEW_ID;
        errorMessage = DEFAULT_ERROR_MESSAGE;
    }

    /**
     * @param context
     * @param iValidator
     * @return SignUpError message related to the validator from resources or from string
     */
    private String getErrorMessage(Context context, IValidator iValidator) {
        try {
            return iValidator.isResId() ?
                    context.getString(iValidator.getErrorMessageId()) : iValidator.getErrorMessage();
        } catch (Throwable e) {
            return "";
        }
    }

    /**
     * @return the view id that associated with the validation.
     */
    protected int getViewId() {
        return viewId;
    }


    /**
     * @return the view that associated with the validation.
     */
    protected TextView getControl() {
        return control;
    }
}
