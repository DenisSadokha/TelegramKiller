package com.example.telegramkiller.data;

import com.example.telegramkiller.presenters.SignInPresenter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AuthUser implements Callback {
    SignInPresenter signInPresenter;
    final String LINK_UP = "http://212.75.210.227:8080/user/v1/registration";
    final String LINK_IN = "http://212.75.210.227:8080/user/v1/login";

    public void signUp(String body, SignInPresenter signInPresenter) {
        this.signInPresenter = signInPresenter;
        AuthRequestHelper authRequestHelper = new AuthRequestHelper();
        authRequestHelper.attach(this);
        authRequestHelper.makeRequest("up", "PUT", body, LINK_UP);

    }

    public  void signIn(String body, SignInPresenter signInPresenter){
        this.signInPresenter = signInPresenter;
        AuthRequestHelper authRequestHelper = new AuthRequestHelper();
        authRequestHelper.attach(this);
        authRequestHelper.makeRequest("up", "PUT", body, LINK_IN);
    }

    @Override
    public void onFailure(Call call, IOException e)
    {
        signInPresenter.responseError("no connect");


    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        switch (response.code()) {
            case 200:
                signInPresenter.responseSuc();
                break;
            case 400:
                signInPresenter.responseError("this account already exists");
                break;
            case 403:
                signInPresenter.responseError("Forbidden");
                break;
            case 404:
                signInPresenter.responseError("error");
                break;
        }


    }
}
