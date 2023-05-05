package com.blitzbit.internal.world.player.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.blitzbit.internal.world.physics.components.PhysicsBodyComponent;
import com.blitzbit.internal.world.physics.components.PositionComponent;
import com.blitzbit.internal.world.physics.components.SpeedComponent;
import com.blitzbit.internal.world.physics.components.VelocityComponent;
import com.blitzbit.internal.world.player.components.InputComponent;
import com.blitzbit.internal.world.view.components.AnimatedSpriteComponent;
import com.blitzbit.internal.world.view.components.CameraFollowComponent;
import com.blitzbit.internal.world.view.components.ColorComponent;
import com.blitzbit.internal.world.view.components.SizeComponent;

public class Player extends Entity {

    public Player(float spawnX, float spawnY) {
        add(new PositionComponent(spawnX, spawnY));
        add(new VelocityComponent());
        add(new SpeedComponent(5.0f));
        add(new InputComponent());
        add(new SizeComponent(1.0f, 1.0f));
        add(new AnimatedSpriteComponent("player_blink", 1 / 2f));
        add(new ColorComponent(Color.GOLDENROD));
        add(new CameraFollowComponent(true));
        add(new PhysicsBodyComponent(BodyDef.BodyType.DynamicBody));
    }
}
