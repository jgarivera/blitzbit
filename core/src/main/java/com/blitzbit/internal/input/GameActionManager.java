package com.blitzbit.internal.input;

import com.badlogic.gdx.Input;
import com.blitzbit.api.input.action.ActionManager;

public class GameActionManager extends ActionManager {

    @Override
    protected void registerActions() {
        addKeyboardAction(Input.Keys.W, GameActionType.MOVE_UP);
        addKeyboardAction(Input.Keys.S, GameActionType.MOVE_DOWN);
        addKeyboardAction(Input.Keys.A, GameActionType.MOVE_LEFT);
        addKeyboardAction(Input.Keys.D, GameActionType.MOVE_RIGHT);
        addKeyboardAction(Input.Keys.O, GameActionType.TOGGLE_DEBUG_MODE);
        addScrollInAction(GameActionType.ZOOM_IN);
        addScrollOutAction(GameActionType.ZOOM_OUT);
        addMouseAction(Input.Buttons.MIDDLE, GameActionType.ZOOM_RESET);
        addMouseAction(Input.Buttons.LEFT, GameActionType.SPAWN_MINION);
    }
}
