package com.blitzbit.core.world;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.blitzbit.core.entity.Flag;
import com.blitzbit.core.entity.Minion;
import com.blitzbit.core.entity.Player;
import com.blitzbit.core.entity.components.InputComponent;
import com.blitzbit.core.entity.systems.CameraSystem;
import com.blitzbit.core.entity.systems.MovementSystem;
import com.blitzbit.core.entity.systems.PlayerInputSystem;
import com.blitzbit.core.entity.systems.SpriteSystem;
import com.blitzbit.core.graphics.GameAssetManager;
import com.blitzbit.core.graphics.GameCamera;
import com.blitzbit.core.graphics.GameOverlay;
import com.blitzbit.core.input.InputActionManager;
import com.blitzbit.core.input.toggle.ToggleManager;
import com.blitzbit.core.physics.GamePhysics;

public class GameWorld {
    private final SpriteBatch batch;
    private final GameCamera camera;
    private final GameOverlay overlay;
    private final Engine engine;

    private final GameAssetManager assetManager;
    private final ToggleManager toggleManager;

    private final GamePhysics physics;

    private final float WORLD_HEIGHT = 1280;
    private final float WORLD_WIDTH = 720;

    public GameWorld(GameAssetManager assetManager) {
        this.assetManager = assetManager;
        toggleManager = new ToggleManager();

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

        InputActionManager inputActionManager = new InputActionManager();
        inputActionManager.subscribe(playerInputSystem);
        inputActionManager.subscribe(cameraSystem);

        Gdx.input.setInputProcessor(inputActionManager);
    }

    public void show() {

    }

    public void render(float delta) {
        if (toggleManager.getToggle(ToggleManager.DEBUG_MODE)) {
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

    public ToggleManager getToggleManager() {
        return toggleManager;
    }
}
