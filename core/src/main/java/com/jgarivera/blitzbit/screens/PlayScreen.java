package com.jgarivera.blitzbit.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.ScreenUtils;
import com.jgarivera.blitzbit.files.GameAssetManager;
import com.jgarivera.blitzbit.world.GameWorld;

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
        world.update(delta);
        world.renderOverlay(delta);
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
