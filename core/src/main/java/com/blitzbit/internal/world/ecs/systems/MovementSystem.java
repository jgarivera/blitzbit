package com.blitzbit.internal.world.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.blitzbit.internal.world.ecs.components.EntityComponentMappers;
import com.blitzbit.internal.world.ecs.components.PhysicsBodyComponent;
import com.blitzbit.internal.world.ecs.components.PositionComponent;
import com.blitzbit.internal.world.ecs.components.VelocityComponent;

public class MovementSystem extends IteratingSystem {

    public MovementSystem() {
        super(Family.all(PositionComponent.class, VelocityComponent.class, PhysicsBodyComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = EntityComponentMappers.position.get(entity);
        VelocityComponent velocity = EntityComponentMappers.velocity.get(entity);
        PhysicsBodyComponent physics = EntityComponentMappers.physics.get(entity);

        Body body = physics.body;
        Vector2 bodyPosition = body.getPosition();

        position.x = bodyPosition.x;
        position.y = bodyPosition.y;

        body.setLinearVelocity(velocity.x, velocity.y);
    }
}
