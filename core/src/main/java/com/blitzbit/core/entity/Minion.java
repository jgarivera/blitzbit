package com.blitzbit.core.entity;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.blitzbit.core.entity.components.*;

public class Minion extends Entity {

    public Minion(float spawnX, float spawnY) {
        add(new PositionComponent(spawnX, spawnY));
        add(new VelocityComponent());
        add(new SpriteComponent("minion.png", -1));
        add(new ColorComponent(Color.FIREBRICK));
        add(new SizeComponent(32.0f, 32.0f));
        add(new PhysicsBodyComponent());
    }
}
