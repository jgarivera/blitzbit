package com.blitzbit.api.graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class Camera extends OrthographicCamera {

    protected final float maxZoom;
    protected final float minZoom;

    public Camera(float screenWidth, float screenHeight, float viewportWidth, float viewportHeight, float minZoom, float maxZoom) {
        super();

        float aspectRatio = screenHeight / screenWidth;

        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight * aspectRatio;

        follow(viewportWidth / 2.0f, viewportHeight / 2.0f);

        this.minZoom = minZoom;
        this.maxZoom = maxZoom;
    }

    public void zoomIn(float units) {
        zoom -= units * 0.25;

        if (zoom <= minZoom) {
            zoom = minZoom;
        }
    }

    public void zoomOut(float units) {
        zoom += units * 0.25;

        if (zoom > maxZoom) {
            zoom = maxZoom;
        }
    }

    public void resetZoom() {
        zoom = 1.0f;
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

    public void resize(int width, int height, float widthMeters) {
        viewportHeight = (widthMeters / width) * height;
        follow(width / 2.0f, height / 2.0f);
    }
}
