package com.blitzbit.internal.world.npcs.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.blitzbit.internal.world.physics.components.PhysicsBodyComponent;
import com.blitzbit.internal.world.physics.components.PositionComponent;
import com.blitzbit.internal.world.physics.components.VelocityComponent;
import com.blitzbit.internal.world.view.components.ColorComponent;
import com.blitzbit.internal.world.view.components.SizeComponent;
import com.blitzbit.internal.world.view.components.SpriteComponent;

public class Minion extends Entity {

    public Minion(float spawnX, float spawnY) {
        add(new PositionComponent(spawnX, spawnY));
        add(new VelocityComponent());
        add(new SpriteComponent("minion.png", -1));
        add(new ColorComponent(Color.FIREBRICK));
        add(new SizeComponent(1.0f, 1.0f));
        add(new PhysicsBodyComponent(BodyDef.BodyType.DynamicBody));
    }
}
