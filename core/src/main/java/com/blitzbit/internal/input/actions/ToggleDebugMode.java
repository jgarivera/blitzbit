package com.blitzbit.internal.input.actions;

import com.blitzbit.internal.input.Action;
import com.blitzbit.internal.input.toggle.ToggleManager;
import com.blitzbit.internal.world.GameWorld;

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
