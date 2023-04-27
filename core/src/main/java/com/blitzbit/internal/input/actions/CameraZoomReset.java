package com.blitzbit.internal.input.actions;

import com.blitzbit.api.input.action.Action;
import com.blitzbit.api.world.World;

public class CameraZoomReset implements Action {

    @Override
    public boolean enter(World world) {
        world.getCamera().resetZoom();
        return true;
    }

    @Override
    public boolean exit(World world) {
        return true;
    }
}
