package com.blitzbit.api.world;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.blitzbit.api.files.AssetManager;
import com.blitzbit.api.graphics.Camera;
import com.blitzbit.api.input.toggle.ToggleManager;
import com.blitzbit.api.world.physics.Physics;

public abstract class World {

    protected final Physics physics;
    protected final Camera camera;
    protected final ToggleManager toggleManager;
    protected final AssetManager assetManager;
    private final Engine engine;

    public World(Engine engine, Physics physics, Camera camera, ToggleManager toggleManager, AssetManager assetManager) {
        this.engine = engine;
        this.physics = physics;
        this.camera = camera;
        this.toggleManager = toggleManager;
        this.assetManager = assetManager;
    }

    public void addEntity(Entity entity) {
        engine.addEntity(entity);
    }

    public void addEntityListenerFor(Family family, EntityListener listener) {
        engine.addEntityListener(family, listener);
    }

    public void addEntityListener(EntityListener listener) {
        engine.addEntityListener(listener);
    }

    public void addSystem(EntitySystem system) {
        engine.addSystem(system);
    }

    public void addSystem(EntitySystem system, int priority) {
        system.priority = priority;
        engine.addSystem(system);
    }

    public ImmutableArray<Entity> getEntitiesFor(Family family) {
        return engine.getEntitiesFor(family);
    }

    public Entity getFirstEntityFor(Family family) {
        return getEntitiesFor(family).first();
    }

    public void update(float delta) {
        physics.update();
        engine.update(delta);
    }

    public abstract Entity getPlayer();

    public Physics getPhysics() {
        return physics;
    }

    public Camera getCamera() {
        return camera;
    }

    public ToggleManager getToggleManager() {
        return toggleManager;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
