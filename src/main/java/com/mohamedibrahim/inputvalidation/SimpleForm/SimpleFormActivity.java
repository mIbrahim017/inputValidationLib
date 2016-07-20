package com.mohamedibrahim.inputvalidation.SimpleForm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mohamedibrahim.inputvalidation.MainActivity;
import com.mohamedibrahim.inputvalidation.R;
import com.mohamedibrahim.inputvalidationlib.Field;
import com.mohamedibrahim.inputvalidationlib.IValidator;
import com.mohamedibrahim.inputvalidationlib.Rules.NumberRule;
import com.mohamedibrahim.inputvalidationlib.Rules.RequiredRule;
import com.mohamedibrahim.inputvalidationlib.ValidationExecutor;

/**
 * Created by mohamed.ibrahim on 7/20/2016.
 */

public class SimpleFormActivity extends AppCompatActivity implements ValidationExecutor.ValidationListener {

    private EditText edTitle;
    private TextView tvTitleError;

    private EditText edBody;
    private TextView tvBodyError;

    private EditText edPhone;
    private TextView tvPhoneError;

    private ValidationExecutor validationExecutor;
    private UIValidation uiValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiValidation = new UIValidation();
        validationExecutor = new ValidationExecutor(this, uiValidation);

        initViews();
        setValidationRules();
    }

    private void initViews() {
        edTitle = (EditText) findViewById(R.id.edTitle);
        tvTitleError = (TextView) findViewById(R.id.tvTitleError);
        edBody = (EditText) findViewById(R.id.edBody);
        tvBodyError = (TextView) findViewById(R.id.tvBodyError);
        edPhone = (EditText) findViewById(R.id.edPhone);
        tvPhoneError = (TextView) findViewById(R.id.tvPhoneError);

    }

    private void setValidationRules() {
        validationExecutor.addFieldValidator(new Field(edTitle).addValidator(new RequiredRule()));
        validationExecutor.addFieldValidator(new Field(edBody).addValidator(new RequiredRule()));
        validationExecutor.addFieldValidator(new Field(edPhone).addValidator(new RequiredRule()).addValidator(new NumberRule()));


    }

    public void onSubmit(View view) {
        validationExecutor.execute();
    }

    @Override
    public void onValidatePass() {
        Toast.makeText(this, "All Validation pass", Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("WrongConstant")
    @Override
    public void handleValidationUI() {
        // set error message text
        tvTitleError.setText(uiValidation.getTitleError());
        tvBodyError.setText(uiValidation.getBodyError());
        tvPhoneError.setText(uiValidation.getPhoneError());


        // set error message visibility
        tvTitleError.setVisibility(uiValidation.getTitleVisibility());
        tvBodyError.setVisibility(uiValidation.getBodyVisibility());
        tvPhoneError.setVisibility(uiValidation.getPhoneVisibility());
    }

    @Override
    public void onValidationFail(TextView field, IValidator iValidator) {
        field.setError(iValidator.getErrorMessage());
    }

}
