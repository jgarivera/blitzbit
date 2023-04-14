package com.blitzbit.api.files;

import com.badlogic.gdx.graphics.Texture;

public abstract class AssetManager extends com.badlogic.gdx.assets.AssetManager {
    public void load() {
        loadTextures();
    }

    protected abstract void loadTextures();

    protected void loadTexture(String filename) {
        load(filename, Texture.class);
    }

    public Texture getTexture(String filename) {
        return get(filename, Texture.class);
    }
}
