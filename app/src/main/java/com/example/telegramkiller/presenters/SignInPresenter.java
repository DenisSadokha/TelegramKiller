package com.example.telegramkiller.presenters;

import com.example.telegramkiller.data.AuthUser;
import com.example.telegramkiller.views.SigInViewContract;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import moxy.InjectViewState;
import moxy.MvpPresenter;
@InjectViewState
public class SignInPresenter extends MvpPresenter<SigInViewContract.SignInView> implements SigInViewContract.SignInPresenter {



    @Override
    public void signUp(String login, String pass, String pass2) {
        getViewState().showLoad();
        AuthUser authUser = new AuthUser();
        if(pass.equals(pass2)){

            JSONObject body = new JSONObject();
            try {
                body.put("login",login);
                body.put("password",pass);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            authUser.signUp(body.toString(), this);


        }



    }

    @Override
    public void signIn(String login, String pass) {
        AuthUser authUser = new AuthUser();
        JSONObject body = new JSONObject();
        try {
            body.put("login",login);
            body.put("password",pass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        authUser.signIn(body.toString(),this);




    }

    public void responseSuc(){
        getViewState().showSuccess();


    }
    public void responseError(String error){
        getViewState().stopLoad();
        getViewState().showError(error);

    }
}
