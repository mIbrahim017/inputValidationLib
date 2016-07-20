package com.mohamedibrahim.inputvalidation.Registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mohamedibrahim.inputvalidation.R;
import com.mohamedibrahim.inputvalidation.validation.rules.ConfirmPasswordRule;
import com.mohamedibrahim.inputvalidation.validation.rules.EmailRule;
import com.mohamedibrahim.inputvalidation.validation.rules.LoginPasswordRule;
import com.mohamedibrahim.inputvalidationlib.Field;
import com.mohamedibrahim.inputvalidationlib.IValidator;
import com.mohamedibrahim.inputvalidationlib.Rules.RequiredRule;
import com.mohamedibrahim.inputvalidationlib.ValidationExecutor;

/**
 * Created by mohamed.ibrahim on 7/20/2016.
 */

public class RegistrationActivity extends AppCompatActivity implements ValidationExecutor.ValidationListener {

    private EditText edMail;
    private TextView tvMailError;

    private EditText edPassword;
    private TextView tvPasswordError;

    private EditText edConfirm;
    private TextView tvConfirmError;

    private ValidationExecutor validationExecutor;
    private RegisterUIValidation uiValidation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        uiValidation = new RegisterUIValidation();
        validationExecutor = new ValidationExecutor(this, uiValidation);

        initViews();
        setValidationRules();

    }

    private void initViews() {
        edMail = (EditText) findViewById(R.id.edMail);
        tvMailError = (TextView) findViewById(R.id.tvMailError);
        edPassword = (EditText) findViewById(R.id.edPassword);
        tvPasswordError = (TextView) findViewById(R.id.tvPasswordError);
        edConfirm = (EditText) findViewById(R.id.edConfirm);
        tvConfirmError = (TextView) findViewById(R.id.tvConfirmError);

    }

    private void setValidationRules() {
        validationExecutor.addFieldValidator(new Field(edMail)
                .addValidator(new RequiredRule())
                .addValidator(new EmailRule()));

        validationExecutor.addFieldValidator(new Field(edPassword)
                .addValidator(new RequiredRule())
                .addValidator(new LoginPasswordRule()));

        validationExecutor.addFieldValidator(new Field(edConfirm)
                .addValidator(new RequiredRule())
                .addValidator(new ConfirmPasswordRule(edPassword.getText().toString())));

    }


    public void onRegisterClick(View view) {
        validationExecutor.execute();
    }

    @Override
    public void onValidatePass() {
        Toast.makeText(this, "All Validation pass", Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("WrongConstant")
    @Override
    public void handleValidationUI() {
        // set error message
        tvMailError.setText(uiValidation.getMailError());
        tvPasswordError.setText(uiValidation.getPasswordError());
        tvConfirmError.setText(uiValidation.getConfirmPasswordError());

        // set error
        edMail.setError(uiValidation.getMailError());
        edPassword.setError(uiValidation.getPasswordError());
        edConfirm.setError(uiValidation.getConfirmPasswordError());

        // set Visibility
        tvMailError.setVisibility(uiValidation.getMailViewVisibility());
        tvPasswordError.setVisibility(uiValidation.getPasswordVisibility());
        tvConfirmError.setVisibility(uiValidation.getConfirmVisibility());

    }

    @Override
    public void onValidationFail(TextView field, IValidator iValidator) {

    }
}
