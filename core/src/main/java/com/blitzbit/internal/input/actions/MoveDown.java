package com.blitzbit.internal.input.actions;

import com.badlogic.ashley.core.Entity;
import com.blitzbit.api.input.action.Action;
import com.blitzbit.api.world.World;
import com.blitzbit.internal.world.physics.components.PhysicsComponentMapper;
import com.blitzbit.internal.world.physics.components.SpeedComponent;
import com.blitzbit.internal.world.physics.components.VelocityComponent;

public class MoveDown implements Action {

    public boolean enter(World world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = PhysicsComponentMapper.VELOCITY.get(player);
        SpeedComponent speed = PhysicsComponentMapper.SPEED.get(player);

        velocity.y = -speed.speed;

        return true;
    }

    public boolean exit(World world) {
        Entity player = world.getPlayer();
        VelocityComponent velocity = PhysicsComponentMapper.VELOCITY.get(player);

        velocity.y = 0;

        return true;
    }
}
