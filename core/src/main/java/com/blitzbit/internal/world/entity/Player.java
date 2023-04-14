package com.blitzbit.internal.world.entity;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.blitzbit.internal.entity.components.*;
import com.blitzbit.internal.world.entity.components.*;

public class Player extends Entity {

    public Player(float spawnX, float spawnY) {
        add(new PositionComponent(spawnX, spawnY));
        add(new VelocityComponent());
        add(new InputComponent());
        add(new SizeComponent(32.0f, 32.0f));
        add(new SpriteComponent("player.png"));
        add(new ColorComponent(Color.GOLDENROD));
        add(new CameraFollowComponent(true));
        add(new PhysicsBodyComponent());
    }
}
