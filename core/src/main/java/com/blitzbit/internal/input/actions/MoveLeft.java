package com.blitzbit.internal.input.actions;

import com.badlogic.ashley.core.Entity;
import com.blitzbit.api.input.action.Action;
import com.blitzbit.api.world.World;
import com.blitzbit.internal.world.ecs.components.EntityComponentMappers;
import com.blitzbit.internal.world.physics.components.SpeedComponent;
import com.blitzbit.internal.world.physics.components.VelocityComponent;

public class MoveLeft implements Action {

    public boolean enter(World world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        SpeedComponent speed = EntityComponentMappers.speed.get(player);

        velocity.x = -speed.speed;

        return true;
    }

    public boolean exit(World world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        velocity.x = 0;

        return true;
    }
}
