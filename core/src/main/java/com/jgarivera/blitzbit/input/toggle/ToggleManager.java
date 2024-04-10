package com.jgarivera.blitzbit.input.toggle;

import java.util.HashMap;

public abstract class ToggleManager {

    private final HashMap<String, Boolean> toggles;

    public ToggleManager() {
        toggles = new HashMap<>();
        registerToggles();
    }

    protected abstract void registerToggles();

    public void setToggle(String name, boolean value) {
        toggles.put(name, value);
    }

    public boolean getToggle(String name) {
        return toggles.get(name);
    }
}
