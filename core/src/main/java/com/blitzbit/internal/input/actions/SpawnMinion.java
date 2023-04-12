package com.blitzbit.internal.input.actions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.blitzbit.internal.entity.Minion;
import com.blitzbit.internal.input.Action;
import com.blitzbit.internal.world.GameWorld;

public class SpawnMinion implements Action {

    public boolean enter(GameWorld world) {
        float x = Gdx.input.getX();
        float y = Gdx.input.getY();

        Vector3 mouseClickPosition = world.getCamera().unproject(new Vector3(x, y, 0));
        world.spawnEntity(new Minion(mouseClickPosition.x, mouseClickPosition.y));

        return true;
    }

    public boolean exit(GameWorld world) {
        return true;
    }
}
