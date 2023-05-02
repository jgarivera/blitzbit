package com.blitzbit.api.graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class Camera extends OrthographicCamera {

    protected final float maxZoom;
    protected final float minZoom;

    public Camera(float viewportWidth, float viewportHeight, float minZoom, float maxZoom) {
        super(viewportWidth, viewportHeight);

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

    public void resize(int screenWidth, int screenHeight, float viewportWidthMeters, float viewportHeightMeters) {
        float viewportWidthRatio = viewportWidthMeters / screenWidth;
        float viewportHeightRatio = viewportHeightMeters / screenHeight;

        viewportHeight = viewportWidthRatio * screenHeight;
        follow(viewportWidthRatio / 2.0f, viewportHeightRatio / 2.0f);
    }
}
