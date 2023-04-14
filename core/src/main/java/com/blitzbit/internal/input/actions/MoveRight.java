package com.blitzbit.internal.input.actions;

import com.badlogic.ashley.core.Entity;
import com.blitzbit.api.input.action.Action;
import com.blitzbit.api.world.World;
import com.blitzbit.internal.world.entity.components.EntityComponentMappers;
import com.blitzbit.internal.world.entity.components.VelocityComponent;

public class MoveRight implements Action {

    public boolean enter(World world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        float speed = 200;

        velocity.x = speed;

        return true;
    }

    public boolean exit(World world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        velocity.x = 0;

        return true;
    }
}
