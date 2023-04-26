package com.blitzbit.internal.world.physics.components;

import com.badlogic.ashley.core.ComponentMapper;
import com.blitzbit.api.world.ecs.EntityComponentMapper;

public class PhysicsComponentMapper extends EntityComponentMapper {

    public static final ComponentMapper<PositionComponent> POSITION = getFor(PositionComponent.class);
    public static final ComponentMapper<VelocityComponent> VELOCITY = getFor(VelocityComponent.class);
    public static final ComponentMapper<SpeedComponent> SPEED = getFor(SpeedComponent.class);
    public static final ComponentMapper<PhysicsBodyComponent> PHYSICS_BODY = getFor(PhysicsBodyComponent.class);
}
