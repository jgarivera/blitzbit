package com.blitzbit.internal.graphics;

import com.badlogic.gdx.Gdx;
import com.blitzbit.api.graphics.Camera;

public class GameCamera extends Camera {
    public static final float MIN_ZOOM = 0.5f;
    public static final float MAX_ZOOM = 2.5f;
    private static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final float VIEWPORT_WIDTH = 312;
    private static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public static final float VIEWPORT_HEIGHT = 312;

    public GameCamera() {
        super(SCREEN_WIDTH, SCREEN_HEIGHT, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, MIN_ZOOM, MAX_ZOOM);
    }
}
