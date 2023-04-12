package com.blitzbit.internal.input;

import com.badlogic.gdx.Input;
import com.blitzbit.api.input.action.ActionManager;

public class GameActionManager extends ActionManager {

    public GameActionManager() {
        registerKeyboardActions();
        registerMouseActions();
    }

    private void registerKeyboardActions() {
        addKeyboardAction(Input.Keys.W, ActionType.MOVE_UP);
        addKeyboardAction(Input.Keys.S, ActionType.MOVE_DOWN);
        addKeyboardAction(Input.Keys.A, ActionType.MOVE_LEFT);
        addKeyboardAction(Input.Keys.D, ActionType.MOVE_RIGHT);
        addKeyboardAction(Input.Keys.O, ActionType.TOGGLE_DEBUG_MODE);
    }

    private void registerMouseActions() {
        addMouseAction(Input.Buttons.LEFT, ActionType.SPAWN_MINION);
    }
}
