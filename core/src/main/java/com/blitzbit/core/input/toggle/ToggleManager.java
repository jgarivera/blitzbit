package com.blitzbit.core.input.toggle;

import java.util.HashMap;

public class ToggleManager {

    public static final String DEBUG_MODE = "debug";

    private final HashMap<String, Boolean> toggles;

    public ToggleManager() {
        toggles = new HashMap<>();
        initialize();
    }

    private void initialize() {
        setToggle(DEBUG_MODE, false);
    }

    public void setToggle(String name, boolean value) {
        toggles.put(name, value);
    }

    public boolean getToggle(String name) {
        return toggles.get(name);
    }
}
