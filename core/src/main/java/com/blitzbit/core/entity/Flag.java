package com.blitzbit.core.entity;

import com.badlogic.ashley.core.Entity;
import com.blitzbit.core.entity.components.*;

public class Flag extends Entity {

    public Flag(float spawnX, float spawnY) {
        add(new PositionComponent(spawnX, spawnY));
        add(new VelocityComponent());
        add(new SpriteComponent("flag.png", 1));
        add(new SizeComponent(48.0f, 48.0f));
        add(new PhysicsBodyComponent());
    }
}
