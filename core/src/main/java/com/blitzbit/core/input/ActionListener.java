package com.blitzbit.core.input;

public interface ActionListener {

    boolean onActionEntered(InputAction action);

    boolean onActionExited(InputAction action);
}
