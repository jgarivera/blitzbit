package com.blitzbit.internal.world.player.listeners;

import com.blitzbit.api.input.action.Action;
import com.blitzbit.api.input.action.ActionListener;
import com.blitzbit.api.input.action.ActionType;
import com.blitzbit.internal.world.GameWorld;

public class PlayerActionListener implements ActionListener {

    private final GameWorld world;

    public PlayerActionListener(GameWorld world) {
        this.world = world;
    }

    @Override
    public boolean onActionEntered(ActionType actionType) {
        Action action = actionType.getAction();

        if (action != null) {
            return action.enter(world);
        }

        return true;
    }

    @Override
    public boolean onActionExited(ActionType actionType) {
        Action action = actionType.getAction();

        if (action != null) {
            return action.exit(world);
        }

        return true;
    }
}
