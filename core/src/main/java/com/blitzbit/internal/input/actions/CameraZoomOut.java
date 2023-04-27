package com.blitzbit.internal.input.actions;

import com.blitzbit.api.input.action.Action;
import com.blitzbit.api.world.World;

public class CameraZoomOut implements Action {

    @Override
    public boolean enter(World world) {
        world.getCamera().zoomOut(0.75f);
        return true;
    }

    @Override
    public boolean exit(World world) {
        return true;
    }
}
