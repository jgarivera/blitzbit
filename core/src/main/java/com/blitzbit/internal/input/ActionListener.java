package com.blitzbit.internal.input;

public interface ActionListener {

    boolean onActionEntered(ActionType action);

    boolean onActionExited(ActionType action);
}
