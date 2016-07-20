package com.mohamedibrahim.inputvalidation.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mohamedibrahim.inputvalidation.validation.rules.EmailRule;
import com.mohamedibrahim.inputvalidation.validation.rules.LoginPasswordRule;
import com.mohamedibrahim.inputvalidation.R;
import com.mohamedibrahim.inputvalidationlib.Field;
import com.mohamedibrahim.inputvalidationlib.IValidator;
import com.mohamedibrahim.inputvalidationlib.Rules.RequiredRule;
import com.mohamedibrahim.inputvalidationlib.ValidationExecutor;

/**
 * Created by mohamed.ibrahim on 7/20/2016.
 */

public class LoginActivity extends AppCompatActivity implements ValidationExecutor.ValidationListener {

    private EditText edMail;
    private TextView tvMailError;
    private EditText edPassword;
    private TextView tvPasswordError;

    private ValidationExecutor validationExecutor;
    private LoginUIValidation uiValidation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        uiValidation = new LoginUIValidation();
        validationExecutor = new ValidationExecutor(this, uiValidation);

        initViews();
        setValidationRules();


    }

    private void setValidationRules() {
        validationExecutor.addFieldValidator(new Field(edMail)
                .addValidator(new RequiredRule())
                .addValidator(new EmailRule()));


        validationExecutor.addFieldValidator(new Field(edPassword)
                .addValidator(new RequiredRule())
                .addValidator(new LoginPasswordRule()));


    }

    private void initViews() {
        edMail = (EditText) findViewById(R.id.edMail);
        edPassword = (EditText) findViewById(R.id.edPassword);

        tvPasswordError = (TextView) findViewById(R.id.tvPasswordError);
        tvMailError = (TextView) findViewById(R.id.tvMailError);


    }

    public void onLoginClick(View view) {
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
        tvMailError.setText(uiValidation.getMailErrorMessage());
        tvPasswordError.setText(uiValidation.getPasswordErrorMessage());

        // set error
        edMail.setError(uiValidation.getMailError());
        edPassword.setError(uiValidation.getPasswordError());

        // set Visibility
        tvMailError.setVisibility(uiValidation.getMailViewVisibility());
        tvPasswordError.setVisibility(uiValidation.getPasswordVisibility());
    }

    @Override
    public void onValidationFail(TextView field, IValidator iValidator) {

    }
}
