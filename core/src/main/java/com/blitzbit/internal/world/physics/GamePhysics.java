package com.blitzbit.internal.world.physics;

import com.blitzbit.api.world.physics.Physics;

public class GamePhysics extends Physics {

    private static final float PIXELS_PER_METER = 32;

    public static float pixelsToMeters(float pixels) {
        return pixels / PIXELS_PER_METER;
    }
}
