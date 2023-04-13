package com.blitzbit.api.input.action;

public interface ActionListener {

    boolean onActionEntered(ActionType action);

    boolean onActionExited(ActionType action);
}
