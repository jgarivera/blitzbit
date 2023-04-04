package com.blitzbit.core.graphics;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class GameAssetManager extends AssetManager {
    public GameAssetManager() {
        super();
    }

    public void load() {
        loadTextures();
    }

    private void loadTextures() {
        loadTexture("player.png");
        loadTexture("minion.png");
        loadTexture("flag.png");
    }

    private void loadTexture(String filename) {
        load(filename, Texture.class);
    }

    public Texture getTexture(String filename) {
        return get(filename, Texture.class);
    }
}
