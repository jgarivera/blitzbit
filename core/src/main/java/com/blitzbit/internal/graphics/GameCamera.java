package com.blitzbit.internal.graphics;

import com.badlogic.gdx.Gdx;
import com.blitzbit.api.graphics.Camera;

public class GameCamera extends Camera {
    public static final float MIN_ZOOM = 1.0f;
    public static final float MAX_ZOOM = 2.5f;
    /**
     * The viewport width in meters.
     */
    public static final float VIEWPORT_WIDTH = 10;
    /**
     * The viewport height in meters.
     */
    public static final float VIEWPORT_HEIGHT = 10;
    private static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    private static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();

    public GameCamera() {
        super(SCREEN_WIDTH, SCREEN_HEIGHT, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, MIN_ZOOM, MAX_ZOOM);
        Gdx.app.debug("GameCamera", String.format("Created game camera with a viewport size: %.2fm by %.2fm", VIEWPORT_WIDTH, VIEWPORT_HEIGHT));
    }
}
