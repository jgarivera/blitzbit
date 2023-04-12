package com.blitzbit.api.input.action;

import com.blitzbit.internal.world.GameWorld;

public interface Action {
    boolean enter(GameWorld world);

    boolean exit(GameWorld world);
}
