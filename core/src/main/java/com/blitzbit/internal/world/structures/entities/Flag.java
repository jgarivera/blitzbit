package com.blitzbit.internal.world.structures.entities;

import com.badlogic.ashley.core.Entity;
import com.blitzbit.internal.world.physics.components.PhysicsBodyComponent;
import com.blitzbit.internal.world.physics.components.PositionComponent;
import com.blitzbit.internal.world.physics.components.VelocityComponent;
import com.blitzbit.internal.world.view.components.SizeComponent;
import com.blitzbit.internal.world.view.components.SpriteComponent;

public class Flag extends Entity {

    public Flag(float spawnX, float spawnY) {
        add(new PositionComponent(spawnX, spawnY));
        add(new VelocityComponent());
        add(new SpriteComponent("flag.png", 1));
        add(new SizeComponent(48.0f, 48.0f));
        add(new PhysicsBodyComponent());
    }
}
