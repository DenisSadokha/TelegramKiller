package com.example.telegramkiller.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.telegramkiller.R;
import com.example.telegramkiller.TestClass;
import com.example.telegramkiller.presenters.SignInPresenter;
import com.example.telegramkiller.views.SigInViewContract;
import com.example.telegramkiller.views.SignUpViewContract;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class SignUpActivity extends MvpAppCompatActivity implements SigInViewContract.SignInView {
    EditText etLogin, etPass1, etPass2;
    Button btnSign;
    @InjectPresenter
    SignInPresenter signInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        etLogin = findViewById(R.id.etLoginUp);
        etPass2 = findViewById(R.id.etPassUpSecond);
        etPass1 = findViewById(R.id.etPassUpFirst);
        btnSign = findViewById(R.id.btnSignUp);
        btnSign.setOnClickListener(v ->
                signInPresenter.signUp(etLogin.getText().toString().trim(),
                etPass1.getText().toString().trim(),
                etPass2.getText().toString().trim())
        );




    }

    @Override
    public void showLoad() {

    }

    @Override
    public void stopLoad() {

    }

    @Override
    public void showSuccess() {
        runOnUiThread(() ->
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show()
        );
        Intent i = new Intent(SignUpActivity.this, TestClass.class);
        startActivity(i);



    }

    @Override
    public void showError(String text) {
        runOnUiThread(() ->
                Toast.makeText(getApplicationContext(), "text", Toast.LENGTH_SHORT).show()
        );


    }
}
