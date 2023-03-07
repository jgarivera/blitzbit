package com.blitzbit.core.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameCamera extends OrthographicCamera {
    public static final float VIEWPORT_HEIGHT = 312;
    public static final float VIEWPORT_WIDTH = 312;

    public GameCamera() {
        super();

        float screenHeight = Gdx.graphics.getHeight();
        float screenWidth = Gdx.graphics.getWidth();
        float aspectRatio = screenHeight / screenWidth;

        viewportWidth = VIEWPORT_WIDTH;
        viewportHeight = VIEWPORT_HEIGHT * aspectRatio;

        follow(viewportWidth / 2.0f, viewportHeight / 2.0f);
    }

    public void follow(float x, float y) {
        position.set(x, y, 0.0f);
        update();
    }

    public void followLerp(float followX, float followY, float interpolation) {
        float cameraX = position.x;
        float cameraY = position.y;

        follow(cameraX + (followX - cameraX) * interpolation, cameraY + (followY - cameraY) * interpolation);
    }

    public void resize(int width, int height) {
        follow(width / 2.0f, height / 2.0f);
    }
}
