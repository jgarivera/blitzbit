package com.blitzbit.internal.physics;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.blitzbit.internal.entity.components.PhysicsBodyComponent;
import com.blitzbit.internal.entity.components.PositionComponent;
import com.blitzbit.internal.entity.listeners.PhysicsBodyListener;

public class GamePhysics {
    private final World world;
    private final Box2DDebugRenderer debugRenderer;
    private static final float PIXELS_PER_METER = 32;

    public GamePhysics() {
        world = new World(new Vector2(0, 0), true);
        debugRenderer = new Box2DDebugRenderer();
    }

    public void register(Engine engine) {
        Family family = Family.all(PositionComponent.class, PhysicsBodyComponent.class).get();
        engine.addEntityListener(family, new PhysicsBodyListener(this));
    }

    public void update(float delta) {
        world.step(1 / 60f, 6, 2);
    }

    public void drawDebug(Matrix4 projectionMatrix) {
        debugRenderer.render(world, projectionMatrix);
    }

    public void dispose() {
        world.dispose();
        debugRenderer.dispose();
    }

    public World getWorld() {
        return world;
    }

    public static float pixelsToMeters(float pixels) {
        return pixels / PIXELS_PER_METER;
    }
}
