package com.blitzbit.core.input;

import com.blitzbit.core.world.GameWorld;

public interface Action {
    boolean enter(GameWorld world);

    boolean exit(GameWorld world);
}
