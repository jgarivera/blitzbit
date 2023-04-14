package com.blitzbit.internal.world.ecs.listeners;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.blitzbit.api.world.physics.Physics;
import com.blitzbit.internal.world.ecs.components.EntityComponentMappers;
import com.blitzbit.internal.world.ecs.components.PhysicsBodyComponent;
import com.blitzbit.internal.world.ecs.components.PositionComponent;
import com.blitzbit.internal.world.ecs.components.SizeComponent;

public class PhysicsBodyListener implements EntityListener {

    private final World physicsWorld;

    public PhysicsBodyListener(Physics physics) {
        physicsWorld = physics.getWorldSimulation();
    }

    @Override
    public void entityAdded(Entity entity) {
        PositionComponent position = EntityComponentMappers.position.get(entity);
        PhysicsBodyComponent physics = EntityComponentMappers.physics.get(entity);
        SizeComponent size = EntityComponentMappers.getSizeComponentOrDefault(entity);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.fixedRotation = true;
        bodyDef.position.set(position.x, position.y);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size.width / 2.0f, size.height / 2.0f);

        Body body = physicsWorld.createBody(bodyDef);
        body.createFixture(shape, 4.0f);
        shape.dispose();

        physics.body = body;

        Gdx.app.debug("Physics", "Created body for entity");
    }


    @Override
    public void entityRemoved(Entity entity) {
        PhysicsBodyComponent physics = EntityComponentMappers.physics.get(entity);
        physicsWorld.destroyBody(physics.body);

        Gdx.app.debug("Physics", "Destroyed body for entity");
    }
}
