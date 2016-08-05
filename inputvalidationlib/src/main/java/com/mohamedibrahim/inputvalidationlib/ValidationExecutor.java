package com.mohamedibrahim.inputvalidationlib;

import android.widget.TextView;

import java.util.ArrayDeque;

/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */

public class ValidationExecutor {
    private final ArrayDeque<FieldValidator> fieldValidators;
    private final ValidationListener validationListener;
    private final BaseUIValidation baseUIValidation;


    public ValidationExecutor(ValidationListener validationListener, BaseUIValidation baseUIValidation) {
        this.validationListener = validationListener;
        this.baseUIValidation = baseUIValidation;
        this.fieldValidators = new ArrayDeque<>();
    }


    public void addFieldValidator(FieldValidator fieldValidator) {
        fieldValidators.add(fieldValidator);
    }


    public void removeFieldValidator(FieldValidator fieldValidator) {
        fieldValidators.remove(fieldValidator);

    }


    public void execute() {


        if (fieldValidators.isEmpty()) {
            validationListener.onValidatePass();
            return;
        }


        for (FieldValidator fieldValidator : fieldValidators) {
            IValidator validate = fieldValidator.validate();
            if (validate != null) {
                baseUIValidation.setupValidationUI(fieldValidator.getControl(), validate);
                validationListener.onValidationFail(fieldValidator.getControl(), validate);
                validationListener.handleValidationUI();
                return;
            }
        }

        baseUIValidation.setValidationPass();
        validationListener.onValidatePass();
        validationListener.handleValidationUI();


    }


    public void removeAllValidators() {
        for (FieldValidator fieldValidator : fieldValidators) {
            fieldValidators.remove(fieldValidator);

        }
    }


    public interface ValidationListener {
        void onValidatePass();

        void handleValidationUI();

        void onValidationFail(TextView field, IValidator iValidator);
    }


}
