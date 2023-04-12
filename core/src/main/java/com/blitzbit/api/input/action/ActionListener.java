package com.blitzbit.api.input.action;

import com.blitzbit.internal.input.ActionType;

public interface ActionListener {

    boolean onActionEntered(ActionType action);

    boolean onActionExited(ActionType action);
}
