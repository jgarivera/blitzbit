package com.blitzbit.internal.world.ecs.components;

import com.badlogic.ashley.core.Component;

public class SpeedComponent implements Component {
    public float speed;

    public SpeedComponent(float speed) {
        this.speed = speed;
    }
}
