package com.example.telegramkiller.inerfaces;

import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface StandartViewAuth {
    void showLoad();
    void stopLoad();
    void showSuccess();
    void showError(String text);
}

