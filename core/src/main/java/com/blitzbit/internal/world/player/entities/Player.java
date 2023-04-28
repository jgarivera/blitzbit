package com.blitzbit.internal.world.player.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.blitzbit.internal.world.physics.components.PhysicsBodyComponent;
import com.blitzbit.internal.world.physics.components.PositionComponent;
import com.blitzbit.internal.world.physics.components.SpeedComponent;
import com.blitzbit.internal.world.physics.components.VelocityComponent;
import com.blitzbit.internal.world.player.components.InputComponent;
import com.blitzbit.internal.world.view.components.CameraFollowComponent;
import com.blitzbit.internal.world.view.components.ColorComponent;
import com.blitzbit.internal.world.view.components.SizeComponent;
import com.blitzbit.internal.world.view.components.SpriteComponent;

public class Player extends Entity {

    public Player(float spawnX, float spawnY) {
        add(new PositionComponent(spawnX, spawnY));
        add(new VelocityComponent());
        add(new SpeedComponent(200.0f));
        add(new InputComponent());
        add(new SizeComponent(32.0f, 32.0f));
        add(new SpriteComponent("player.png"));
        add(new ColorComponent(Color.GOLDENROD));
        add(new CameraFollowComponent(true));
        add(new PhysicsBodyComponent(BodyDef.BodyType.DynamicBody));
    }
}
