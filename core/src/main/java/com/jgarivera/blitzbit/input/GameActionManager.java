package com.jgarivera.blitzbit.input;

import com.badlogic.gdx.Input;
import com.jgarivera.blitzbit.input.action.ActionManager;

public class GameActionManager extends ActionManager {

    @Override
    protected void registerActions() {
        registerKeyboardActions();
        registerMouseActions();
    }

    private void registerKeyboardActions() {
        addKeyboardAction(Input.Keys.W, GameActionType.MOVE_UP);
        addKeyboardAction(Input.Keys.S, GameActionType.MOVE_DOWN);
        addKeyboardAction(Input.Keys.A, GameActionType.MOVE_LEFT);
        addKeyboardAction(Input.Keys.D, GameActionType.MOVE_RIGHT);
        addKeyboardAction(Input.Keys.O, GameActionType.TOGGLE_DEBUG_MODE);
        addKeyboardAction(Input.Keys.P, GameActionType.SPAWN_MINION);
    }

    private void registerMouseActions() {
        addMouseAction(Input.Buttons.MIDDLE, GameActionType.ZOOM_RESET);
        addScrollInAction(GameActionType.ZOOM_IN);
        addScrollOutAction(GameActionType.ZOOM_OUT);
    }
}
