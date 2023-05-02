package com.blitzbit.internal.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.blitzbit.api.graphics.Camera;
import com.blitzbit.api.world.World;

public class GameOverlay {

    private final World world;
    private final SpriteBatch batch;
    private final BitmapFont font;

    public GameOverlay(World world) {
        this.world = world;
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    public void render(float delta) {
        int screenHeight = Gdx.graphics.getHeight();

        batch.begin();

        int fps = Gdx.graphics.getFramesPerSecond();
        font.draw(batch, String.format("FPS: %d", fps), 15, screenHeight - 15);

        Camera camera = world.getCamera();
        Vector3 cameraPos = camera.position;
        font.draw(batch, String.format("cam_x: %.2fm, cam_y: %.2fm", cameraPos.x, cameraPos.y), 15, screenHeight - 30);
        font.draw(batch, String.format("cam_zoom: %.2f", camera.zoom), 15, screenHeight - 45);

        batch.end();
    }

    public void resize(int width, int height) {
        batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
    }
}
