package com.blitzbit.internal.world.ecs.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.blitzbit.api.input.action.Action;
import com.blitzbit.api.input.action.ActionListener;
import com.blitzbit.api.input.action.ActionType;
import com.blitzbit.internal.world.GameWorld;

public class PlayerInputSystem extends EntitySystem implements ActionListener {

    private final GameWorld world;

    public PlayerInputSystem(GameWorld world) {
        this.world = world;
    }

    @Override
    public boolean onActionEntered(ActionType actionType) {
        if (!checkProcessing()) {
            return false;
        }

        Action action = actionType.getAction();

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

        Action action = actionType.getAction();

        if (action != null) {
            return action.exit(world);
        }

        return true;
    }
}
