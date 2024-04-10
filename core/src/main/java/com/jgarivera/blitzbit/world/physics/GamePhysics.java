package com.jgarivera.blitzbit.world.physics;

public class GamePhysics extends Physics {

    private static final float UNIT = 32.0f;
    public static final float PIXELS_TO_METERS = 1 / UNIT;

    public static float pixelsToMeters(float pixels) {
        return pixels * PIXELS_TO_METERS;
    }
}
