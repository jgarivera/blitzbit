package com.blitzbit.internal.input.actions;

import com.badlogic.ashley.core.Entity;
import com.blitzbit.internal.entity.components.EntityComponentMappers;
import com.blitzbit.internal.entity.components.VelocityComponent;
import com.blitzbit.internal.input.Action;
import com.blitzbit.internal.world.GameWorld;

public class MoveRight implements Action {

    public boolean enter(GameWorld world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        float speed = 200;

        velocity.x = speed;

        return true;
    }

    public boolean exit(GameWorld world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        velocity.x = 0;

        return true;
    }
}
