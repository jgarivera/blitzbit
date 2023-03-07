package com.blitzbit.core.entity.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.Body;
import com.blitzbit.core.entity.components.EntityComponentMappers;
import com.blitzbit.core.entity.components.PhysicsComponent;
import com.blitzbit.core.entity.components.PositionComponent;
import com.blitzbit.core.entity.components.VelocityComponent;
import com.blitzbit.core.physics.GamePhysics;
import com.blitzbit.core.world.GameWorld;

public class MovementSystem extends IteratingSystem {

    public MovementSystem() {
        super(Family.all(PositionComponent.class, VelocityComponent.class, PhysicsComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = EntityComponentMappers.position.get(entity);
        VelocityComponent velocity = EntityComponentMappers.velocity.get(entity);
        PhysicsComponent physics = EntityComponentMappers.physics.get(entity);

        Body body = physics.body;
        body.setLinearVelocity(velocity.x, velocity.y);

        position.x = body.getPosition().x;
        position.y = body.getPosition().y;
    }
}
