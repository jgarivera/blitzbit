package com.blitzbit.api.world.physics;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Physics {
    private final World worldSimulation;
    private final Box2DDebugRenderer debugRenderer;

    public Physics() {
        Box2D.init();
        worldSimulation = new World(new Vector2(0, 0), true);
        debugRenderer = new Box2DDebugRenderer();
    }

    public void update() {
        worldSimulation.step(1 / 60f, 6, 2);
    }

    public void drawDebug(Matrix4 projectionMatrix) {
        debugRenderer.render(worldSimulation, projectionMatrix);
    }

    public void dispose() {
        worldSimulation.dispose();
        debugRenderer.dispose();
    }

    public World getWorldSimulation() {
        return worldSimulation;
    }
}
