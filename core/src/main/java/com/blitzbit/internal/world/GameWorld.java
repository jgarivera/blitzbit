package com.blitzbit.internal.world;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.blitzbit.internal.entity.Flag;
import com.blitzbit.internal.entity.Minion;
import com.blitzbit.internal.entity.Player;
import com.blitzbit.internal.entity.components.InputComponent;
import com.blitzbit.internal.entity.systems.CameraSystem;
import com.blitzbit.internal.entity.systems.MovementSystem;
import com.blitzbit.internal.entity.systems.PlayerInputSystem;
import com.blitzbit.internal.entity.systems.SpriteSystem;
import com.blitzbit.internal.graphics.GameAssetManager;
import com.blitzbit.internal.graphics.GameCamera;
import com.blitzbit.internal.graphics.GameOverlay;
import com.blitzbit.internal.input.GameActionManager;
import com.blitzbit.internal.input.GameToggleManager;
import com.blitzbit.internal.physics.GamePhysics;

public class GameWorld {
    private final SpriteBatch batch;
    private final GameCamera camera;
    private final GameOverlay overlay;
    private final Engine engine;

    private final GameAssetManager assetManager;
    private final GameToggleManager toggleManager;

    private final GamePhysics physics;

    private final float WORLD_HEIGHT = 1280;
    private final float WORLD_WIDTH = 720;

    public GameWorld(GameAssetManager assetManager) {
        this.assetManager = assetManager;
        toggleManager = new GameToggleManager();

        batch = new SpriteBatch();
        camera = new GameCamera();
        overlay = new GameOverlay();
        engine = new Engine();

        physics = new GamePhysics();
        physics.register(engine);

        spawnEntity(new Player(0, 0));
        spawnEntity(new Minion(100, 100));
        spawnEntity(new Minion(200, 50));
        spawnEntity(new Flag(175, 175));

        setupEngine();
    }

    private void setupEngine() {
        engine.addSystem(new SpriteSystem(this, batch));

        CameraSystem cameraSystem = new CameraSystem(this);
        engine.addSystem(cameraSystem);

        engine.addSystem(new MovementSystem());

        PlayerInputSystem playerInputSystem = new PlayerInputSystem(this);
        engine.addSystem(playerInputSystem);

        GameActionManager actionManager = new GameActionManager();
        actionManager.subscribe(playerInputSystem);
        actionManager.subscribe(cameraSystem);

        Gdx.input.setInputProcessor(actionManager);
    }

    public void show() {

    }

    public void render(float delta) {
        if (toggleManager.getToggle(GameToggleManager.DEBUG_MODE)) {
            physics.drawDebug(camera.combined);
        }

        batch.setProjectionMatrix(camera.combined);

        physics.update(delta);
        engine.update(delta);
        overlay.render(delta);
    }

    public void resize(int width, int height) {
        camera.resize(width, height);
    }

    public void dispose() {
        batch.dispose();
        physics.dispose();
    }

    public void spawnEntity(Entity entity) {
        engine.addEntity(entity);
    }

    /**
     * Assumes the only entity with an InputComponent is the player
     */
    public Entity getPlayer() {
        ImmutableArray<Entity> controllableEntities = engine.getEntitiesFor(Family.all(InputComponent.class).get());
        return controllableEntities.first();
    }

    public GameCamera getCamera() {
        return camera;
    }

    public GameAssetManager getAssetManager() {
        return assetManager;
    }

    public GamePhysics getPhysics() {
        return physics;
    }

    public GameToggleManager getToggleManager() {
        return toggleManager;
    }
}
