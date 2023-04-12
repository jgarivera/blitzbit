package com.blitzbit.internal.input;

import com.blitzbit.internal.world.GameWorld;

public interface Action {
    boolean enter(GameWorld world);

    boolean exit(GameWorld world);
}
