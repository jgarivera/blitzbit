package com.blitzbit.internal.input;

import com.blitzbit.api.input.toggle.ToggleManager;

public class GameToggleManager extends ToggleManager {
    public static final String DEBUG_MODE = "debug";

    public GameToggleManager() {
        super();
    }

    @Override
    protected void registerToggles() {
        setToggle(DEBUG_MODE, false);
    }
}
