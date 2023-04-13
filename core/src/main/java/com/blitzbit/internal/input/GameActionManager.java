package com.blitzbit.internal.input;

import com.badlogic.gdx.Input;
import com.blitzbit.api.input.action.ActionManager;

public class GameActionManager extends ActionManager {

    @Override
    protected void registerKeyboardActions() {
        addKeyboardAction(Input.Keys.W, GameActionType.MOVE_UP);
        addKeyboardAction(Input.Keys.S, GameActionType.MOVE_DOWN);
        addKeyboardAction(Input.Keys.A, GameActionType.MOVE_LEFT);
        addKeyboardAction(Input.Keys.D, GameActionType.MOVE_RIGHT);
        addKeyboardAction(Input.Keys.O, GameActionType.TOGGLE_DEBUG_MODE);
    }

    @Override
    protected void registerMouseActions() {
        addMouseAction(Input.Buttons.LEFT, GameActionType.SPAWN_MINION);
    }
}
