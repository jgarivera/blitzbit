package com.blitzbit;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.blitzbit.BlitzbitGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        config.setTitle("Blitzbit");
        config.setForegroundFPS(60);
        config.useVsync(false);
        config.setWindowSizeLimits(640, 480, 640, 480);

        new Lwjgl3Application(new BlitzbitGame(), config);
    }
}
