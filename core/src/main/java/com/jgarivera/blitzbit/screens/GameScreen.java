package com.jgarivera.blitzbit.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ScreenAdapter;

public abstract class GameScreen extends ScreenAdapter {
    protected final Game game;

    public GameScreen(Game game) {
        this.game = game;
    }
}
