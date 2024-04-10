package com.jgarivera.blitzbit.input.actions;

import com.jgarivera.blitzbit.input.action.Action;
import com.jgarivera.blitzbit.input.toggle.ToggleManager;
import com.jgarivera.blitzbit.world.World;
import com.jgarivera.blitzbit.input.GameToggleManager;

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
