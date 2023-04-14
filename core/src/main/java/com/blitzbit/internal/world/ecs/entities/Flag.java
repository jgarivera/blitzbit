package com.blitzbit.internal.world.ecs.entities;

import com.badlogic.ashley.core.Entity;
import com.blitzbit.internal.world.ecs.components.*;

public class Flag extends Entity {

    public Flag(float spawnX, float spawnY) {
        add(new PositionComponent(spawnX, spawnY));
        add(new VelocityComponent());
        add(new SpriteComponent("flag.png", 1));
        add(new SizeComponent(48.0f, 48.0f));
        add(new PhysicsBodyComponent());
    }
}
