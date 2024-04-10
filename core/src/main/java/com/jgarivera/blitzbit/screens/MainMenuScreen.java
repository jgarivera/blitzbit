package com.jgarivera.blitzbit.screens;

import com.badlogic.gdx.Game;
import com.jgarivera.blitzbit.files.GameAssetManager;

public class MainMenuScreen extends GameScreen {
    private final GameAssetManager assetManager;

    public MainMenuScreen(Game game) {
        super(game);
        assetManager = new GameAssetManager();
        assetManager.load();
    }

    @Override
    public void render(float delta) {
        if (assetManager.update()) {
            game.setScreen(new PlayScreen(game, assetManager));
        }
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
