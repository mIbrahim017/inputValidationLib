package com.mohamedibrahim.inputvalidationlib;

import android.widget.TextView;

/**
 * Created by mohamed.ibrahim on 7/19/2016.
 */

public interface FieldValidator {

    IValidator validate();

    TextView getControl();


    FieldValidator addValidator(IValidator iValidator);


}
