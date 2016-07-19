package com.mohamedibrahim.inputvalidationlib;

import java.util.ArrayDeque;

/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */

public class ValidationExecutor {
    private final ArrayDeque<FieldValidator> fieldValidators;
    private final ValidationListener validationListener;


    public ValidationExecutor(ValidationListener validationListener) {
        this.validationListener = validationListener;
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
                validationListener.onValidationFail(fieldValidator, validate);
                validationListener.handleValidationUI();
                return;
            }
        }

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

        void onValidationFail(FieldValidator field, IValidator iValidator);
    }


}
