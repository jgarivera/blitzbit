package com.blitzbit.internal.input.actions;

import com.badlogic.ashley.core.Entity;
import com.blitzbit.internal.entity.components.EntityComponentMappers;
import com.blitzbit.internal.entity.components.VelocityComponent;
import com.blitzbit.api.input.action.Action;
import com.blitzbit.internal.world.GameWorld;

public class MoveUp implements Action {

    public boolean enter(GameWorld world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        float speed = 200;

        velocity.y = speed;

        return true;
    }

    public boolean exit(GameWorld world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        velocity.y = 0;

        return true;
    }
}
