package com.blitzbit.api.input.action;

import com.blitzbit.api.world.World;

public interface Action {
    boolean enter(World world);

    boolean exit(World world);
}
