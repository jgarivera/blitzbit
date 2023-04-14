package com.blitzbit.internal.graphics;

import com.badlogic.gdx.Gdx;
import com.blitzbit.api.graphics.Camera;

public class GameCamera extends Camera {
    public static final float VIEWPORT_HEIGHT = 312;
    public static final float VIEWPORT_WIDTH = 312;

    public GameCamera() {
        super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
    }
}
