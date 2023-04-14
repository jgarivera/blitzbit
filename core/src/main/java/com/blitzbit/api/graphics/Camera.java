package com.blitzbit.api.graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class Camera extends OrthographicCamera {

    public Camera(float screenWidth, float screenHeight, float viewportWidth, float viewportHeight) {
        super();

        float aspectRatio = screenHeight / screenWidth;

        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportWidth * aspectRatio;

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
