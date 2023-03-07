package com.blitzbit.core.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.blitzbit.core.graphics.GameAssetManager;
import com.blitzbit.core.world.GameWorld;

public class PlayScreen extends GameScreen {

    private final GameWorld world;

    public PlayScreen(Game game, GameAssetManager assetManager) {
        super(game);
        world = new GameWorld(assetManager);
    }

    @Override
    public void show() {
        world.show();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        world.render(delta);
        Gdx.app.log("debug", "FPS: " + Gdx.graphics.getFramesPerSecond());
    }

    @Override
    public void resize(int width, int height) {
        world.resize(width, height);
    }

    @Override
    public void dispose() {
        world.dispose();
    }
}
