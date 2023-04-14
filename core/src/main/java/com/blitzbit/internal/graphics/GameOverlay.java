package com.blitzbit.internal.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverlay {

    private final SpriteBatch batch;
    private final BitmapFont font;

    public GameOverlay() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    public void render(float delta) {
        int fps = Gdx.graphics.getFramesPerSecond();
        batch.begin();
        font.draw(batch, String.format("FPS: %d", fps), 15, Gdx.graphics.getHeight() - 15);
        batch.end();
    }
}
