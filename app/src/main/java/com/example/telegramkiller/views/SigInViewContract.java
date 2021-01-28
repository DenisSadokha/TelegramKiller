package com.example.telegramkiller.views;

import com.example.telegramkiller.inerfaces.StandartViewAuth;

import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface SigInViewContract {
    @StateStrategyType(OneExecutionStateStrategy.class)
    interface SignInView extends MvpView, StandartViewAuth {

    }

    interface SignInPresenter {
        void signUp(String login, String pass, String pass2);
        void signIn(String login, String pass);


    }
}