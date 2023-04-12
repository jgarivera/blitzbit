package com.blitzbit;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.blitzbit.internal.screens.MainMenuScreen;

public class BlitzbitGame extends Game {

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        this.setScreen(new MainMenuScreen(this));
    }
}
