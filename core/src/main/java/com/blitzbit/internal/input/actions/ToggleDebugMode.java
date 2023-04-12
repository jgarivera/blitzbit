package com.blitzbit.internal.input.actions;

import com.blitzbit.api.input.action.Action;
import com.blitzbit.api.input.toggle.ToggleManager;
import com.blitzbit.internal.input.GameToggleManager;
import com.blitzbit.internal.world.GameWorld;

public class ToggleDebugMode implements Action {

    public boolean enter(GameWorld world) {
        GameToggleManager toggleManager = world.getToggleManager();
        boolean isDebugMode = toggleManager.getToggle(GameToggleManager.DEBUG_MODE);

        toggleManager.setToggle(GameToggleManager.DEBUG_MODE, !isDebugMode);

        return true;
    }

    public boolean exit(GameWorld world) {
        return true;
    }
}
