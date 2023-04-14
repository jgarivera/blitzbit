package com.blitzbit.internal.input;

import com.blitzbit.api.input.action.Action;
import com.blitzbit.api.input.action.ActionType;
import com.blitzbit.internal.input.actions.*;

public enum GameActionType implements ActionType {
    MOVE_UP(new MoveUp()),
    MOVE_DOWN(new MoveDown()),
    MOVE_LEFT(new MoveLeft()),
    MOVE_RIGHT(new MoveRight()),
    SPAWN_MINION(new SpawnMinion()),
    STOP_FOLLOW_CAMERA(null),
    TOGGLE_DEBUG_MODE(new ToggleDebugMode());

    private final Action action;

    GameActionType(Action action) {
        this.action = action;
    }

    @Override
    public Action getAction() {
        return action;
    }
}
