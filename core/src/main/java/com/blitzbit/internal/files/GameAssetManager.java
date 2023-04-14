package com.blitzbit.internal.files;


import com.blitzbit.api.files.AssetManager;

public class GameAssetManager extends AssetManager {

    @Override
    protected void loadTextures() {
        loadTexture("player.png");
        loadTexture("minion.png");
        loadTexture("flag.png");
    }
}