package com.blitzbit.api.files;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public abstract class AssetManager extends com.badlogic.gdx.assets.AssetManager {
    public void load() {
        loadTextures();
    }

    protected abstract void loadTextures();

    protected void loadTexture(String filename) {
        load(filename, Texture.class);
    }

    protected void loadTextureAtlas(String filename) {
        load(filename, TextureAtlas.class);
    }

    public Texture getTexture(String filename) {
        return get(filename, Texture.class);
    }

    public TextureAtlas getTextureAtlas(String filename) {
        return get(filename, TextureAtlas.class);
    }
}
