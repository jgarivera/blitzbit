package com.blitzbit.core.entity.listeners;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
import com.blitzbit.core.entity.components.EntityComponentMappers;
import com.blitzbit.core.entity.components.PhysicsBodyComponent;
import com.blitzbit.core.entity.components.PositionComponent;
import com.blitzbit.core.entity.components.SizeComponent;
import com.blitzbit.core.physics.GamePhysics;

public class PhysicsBodyListener implements EntityListener {
    private final GamePhysics physics;
    private final World physicsWorld;

    public PhysicsBodyListener(GamePhysics physics) {
        this.physics = physics;
        physicsWorld = physics.getWorld();
    }

    @Override
    public void entityAdded(Entity entity) {
        PositionComponent position = EntityComponentMappers.position.get(entity);
        SizeComponent size = EntityComponentMappers.size.get(entity);
        PhysicsBodyComponent physics = EntityComponentMappers.physics.get(entity);

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
