package com.blitzbit.core.input.actions;

import com.badlogic.ashley.core.Entity;
import com.blitzbit.core.entity.components.EntityComponentMappers;
import com.blitzbit.core.entity.components.VelocityComponent;
import com.blitzbit.core.input.Action;
import com.blitzbit.core.world.GameWorld;

public class MoveLeft implements Action {

    public boolean enter(GameWorld world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        float speed = 200;

        velocity.x = -speed;

        return true;
    }

    public boolean exit(GameWorld world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        velocity.x = 0;

        return true;
    }
}
