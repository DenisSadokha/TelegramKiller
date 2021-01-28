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

import javax.inject.Inject;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class SignInActivity extends MvpAppCompatActivity implements View.OnClickListener, SigInViewContract.SignInView {
    EditText etPass, etLogin;
    Button btnSign;
    @InjectPresenter
    SignInPresenter signInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);
        etLogin = findViewById(R.id.etLoginIn);
        etPass = findViewById(R.id.etPassIn);
        btnSign = findViewById(R.id.btnSignIn);
        btnSign.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                signInPresenter.signIn(etLogin.getText().toString(), etPass.getText().toString());
                break;
        }
    }

    @Override
    public void showSuccess() {
        runOnUiThread(() ->
                Toast.makeText(getApplicationContext(), "успешно", Toast.LENGTH_SHORT).show()
        );
        Intent intent = new Intent(SignInActivity.this, TestClass.class);
        startActivity(intent);


    }

    @Override
    public void showError(String text) {
        runOnUiThread(() ->
                Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show()
        );

    }

    @Override
    public void showLoad() {


    }

    @Override
    public void stopLoad() {

    }
}
