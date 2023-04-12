package com.blitzbit.api.input.toggle;

import java.util.HashMap;

public class ToggleManager {

    private final HashMap<String, Boolean> toggles;

    public ToggleManager() {
        toggles = new HashMap<>();
    }

    public void setToggle(String name, boolean value) {
        toggles.put(name, value);
    }

    public boolean getToggle(String name) {
        return toggles.get(name);
    }
}
