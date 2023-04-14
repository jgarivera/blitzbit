package com.blitzbit.internal.input.actions;

import com.blitzbit.api.input.action.Action;
import com.blitzbit.api.input.toggle.ToggleManager;
import com.blitzbit.api.world.World;
import com.blitzbit.internal.input.GameToggleManager;

public class ToggleDebugMode implements Action {

    public boolean enter(World world) {
        ToggleManager toggleManager = world.getToggleManager();
        boolean isDebugMode = toggleManager.getToggle(GameToggleManager.DEBUG_MODE);

        toggleManager.setToggle(GameToggleManager.DEBUG_MODE, !isDebugMode);

        return true;
    }

    public boolean exit(World world) {
        return true;
    }
}
