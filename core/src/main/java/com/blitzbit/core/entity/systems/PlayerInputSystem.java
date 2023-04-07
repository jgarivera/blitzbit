package com.blitzbit.core.entity.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.blitzbit.core.input.Action;
import com.blitzbit.core.input.ActionListener;
import com.blitzbit.core.input.ActionType;
import com.blitzbit.core.input.actions.*;
import com.blitzbit.core.world.GameWorld;

import java.util.HashMap;
import java.util.Map;

public class PlayerInputSystem extends EntitySystem implements ActionListener {

    private final GameWorld world;

    private final Map<ActionType, Action> actions;

    public PlayerInputSystem(GameWorld world) {
        this.world = world;
        actions = new HashMap<>();
        registerActions();
    }

    private void registerActions() {
        actions.put(ActionType.MOVE_UP, new MoveUp());
        actions.put(ActionType.MOVE_DOWN, new MoveDown());
        actions.put(ActionType.MOVE_LEFT, new MoveLeft());
        actions.put(ActionType.MOVE_RIGHT, new MoveRight());
        actions.put(ActionType.SPAWN_MINION, new SpawnMinion());
    }

    @Override
    public boolean onActionEntered(ActionType actionType) {
        if (!checkProcessing()) {
            return false;
        }

        Action action = actions.get(actionType);

        if (action != null) {
            return action.enter(world);
        }

        return true;
    }

    @Override
    public boolean onActionExited(ActionType actionType) {
        if (!checkProcessing()) {
            return false;
        }

        Action action = actions.get(actionType);

        if (action != null) {
            return action.exit(world);
        }

        return true;
    }
}
