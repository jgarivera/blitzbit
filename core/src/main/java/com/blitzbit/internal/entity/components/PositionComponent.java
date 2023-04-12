package com.blitzbit.internal.entity.components;

import com.badlogic.ashley.core.Component;

public class PositionComponent implements Component {
    public float x = 0.0f;
    public float y = 0.0f;

    public PositionComponent() {
    }

    public PositionComponent(float x, float y) {
        this.x = x;
        this.y = y;
    }
}