package com.mohamedibrahim.inputvalidationlib;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */

public class Field implements FieldValidator {

    private final TextView control;
    private final List<IValidator> validatorList = new ArrayList<>();

    public Field(TextView control) {
        this.control = control;
    }


    @Override
    public IValidator validate() {
        final String value = getValue();
        final int size = validatorList.size();
        for (int i = 0; i < size; i++) {
            IValidator iValidator = validatorList.get(i);
            if (!iValidator.validateValue(value)) {
                return iValidator;
            }
        }


        return null;
    }

    @Override
    public TextView getControl() {
        return control;
    }

    private String getValue() {
        return getControl().getText().toString();
    }

    @Override
    public FieldValidator addValidator(IValidator iValidator) {
        validatorList.add(iValidator);
        return this;
    }
}
