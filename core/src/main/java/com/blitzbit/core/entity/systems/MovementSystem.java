package com.blitzbit.core.entity.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.Body;
import com.blitzbit.core.entity.components.EntityComponentMappers;
import com.blitzbit.core.entity.components.PhysicsBodyComponent;
import com.blitzbit.core.entity.components.PositionComponent;
import com.blitzbit.core.entity.components.VelocityComponent;

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
        body.setLinearVelocity(velocity.x, velocity.y);

        position.x = body.getPosition().x;
        position.y = body.getPosition().y;
    }
}
