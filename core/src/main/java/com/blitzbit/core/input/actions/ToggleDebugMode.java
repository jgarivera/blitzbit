package com.blitzbit.core.input.actions;

import com.blitzbit.core.input.Action;
import com.blitzbit.core.input.toggle.ToggleManager;
import com.blitzbit.core.world.GameWorld;

public class ToggleDebugMode implements Action {

    public boolean enter(GameWorld world) {
        ToggleManager toggleManager = world.getToggleManager();
        boolean isDebugMode = toggleManager.getToggle(ToggleManager.DEBUG_MODE);

        toggleManager.setToggle(ToggleManager.DEBUG_MODE, !isDebugMode);

        return true;
    }

    public boolean exit(GameWorld world) {
        return true;
    }
}
