package com.jgarivera.blitzbit.files;


public class GameAssetManager extends AssetManager {

    @Override
    protected void loadTextures() {
        loadTextureAtlas("pack.atlas");
        loadTexture("player.png");
        loadTexture("minion.png");
        loadTexture("flag.png");
    }
}
