package com.blitzbit.core.entity.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.blitzbit.core.entity.Minion;
import com.blitzbit.core.entity.components.EntityComponentMappers;
import com.blitzbit.core.entity.components.VelocityComponent;
import com.blitzbit.core.input.ActionListener;
import com.blitzbit.core.input.InputAction;
import com.blitzbit.core.world.GameWorld;

public class PlayerInputSystem extends EntitySystem implements ActionListener {

    private final GameWorld world;

    private final Entity player;

    public PlayerInputSystem(GameWorld world) {
        this.world = world;
        player = world.getPlayer();
    }

    @Override
    public boolean onActionEntered(InputAction action) {
        if (!checkProcessing()) {
            return false;
        }

        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);
        float speed = 200;

        switch (action) {
            case MOVE_UP:
                velocity.y = speed;
                return true;
            case MOVE_DOWN:
                velocity.y = -speed;
                return true;
            case MOVE_LEFT:
                velocity.x = -speed;
                return true;
            case MOVE_RIGHT:
                velocity.x = speed;
                return true;
            case SPAWN_MINION:
                float x = Gdx.input.getX();
                float y = Gdx.input.getY();

                world.spawnEntity(new Minion(x, y));
                return true;
        }

        return true;
    }

    @Override
    public boolean onActionExited(InputAction action) {
        if (!checkProcessing()) {
            return false;
        }

        VelocityComponent velocity = EntityComponentMappers.velocity.get(player);

        switch (action) {
            case MOVE_UP:
            case MOVE_DOWN:
                velocity.y = 0;
                return true;
            case MOVE_LEFT:
            case MOVE_RIGHT:
                velocity.x = 0;
                return true;
        }

        return true;
    }
}
