package com.blitzbit.core.input;

public interface ActionListener {

    boolean onActionEntered(ActionType action);

    boolean onActionExited(ActionType action);
}
