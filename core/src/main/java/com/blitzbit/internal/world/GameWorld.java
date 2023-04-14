package com.blitzbit.internal.world;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.blitzbit.api.world.World;
import com.blitzbit.internal.entity.Flag;
import com.blitzbit.internal.entity.Minion;
import com.blitzbit.internal.entity.Player;
import com.blitzbit.internal.entity.components.InputComponent;
import com.blitzbit.internal.entity.components.PhysicsBodyComponent;
import com.blitzbit.internal.entity.components.PositionComponent;
import com.blitzbit.internal.entity.listeners.PhysicsBodyListener;
import com.blitzbit.internal.entity.systems.CameraSystem;
import com.blitzbit.internal.entity.systems.MovementSystem;
import com.blitzbit.internal.entity.systems.PlayerInputSystem;
import com.blitzbit.internal.entity.systems.SpriteSystem;
import com.blitzbit.internal.files.GameAssetManager;
import com.blitzbit.internal.graphics.GameCamera;
import com.blitzbit.internal.graphics.GameOverlay;
import com.blitzbit.internal.input.GameActionManager;
import com.blitzbit.internal.input.GameToggleManager;
import com.blitzbit.internal.physics.GamePhysics;

public class GameWorld extends World {
    private final SpriteBatch batch;

    private final GameOverlay overlay;

    private final float WORLD_HEIGHT = 1280;
    private final float WORLD_WIDTH = 720;

    public GameWorld(GameAssetManager assetManager) {
        super(new Engine(), new GamePhysics(), new GameCamera(), new GameToggleManager(), assetManager);

        batch = new SpriteBatch();
        overlay = new GameOverlay();

        setupEngine();

        addEntity(new Player(0, 0));
        addEntity(new Minion(100, 100));
        addEntity(new Minion(200, 50));
        addEntity(new Flag(175, 175));
    }

    private void setupEngine() {
        addSystem(new SpriteSystem(this, batch));

        CameraSystem cameraSystem = new CameraSystem(this);
        addSystem(cameraSystem);

        addSystem(new MovementSystem());

        PlayerInputSystem playerInputSystem = new PlayerInputSystem(this);
        addSystem(playerInputSystem);

        GameActionManager actionManager = new GameActionManager();
        actionManager.subscribe(playerInputSystem);
        actionManager.subscribe(cameraSystem);

        Gdx.input.setInputProcessor(actionManager);

        Family family = Family.all(PositionComponent.class, PhysicsBodyComponent.class).get();
        addEntityListenerFor(family, new PhysicsBodyListener(physics));
    }

    public void show() {

    }

    public void render(float delta) {
        if (toggleManager.getToggle(GameToggleManager.DEBUG_MODE)) {
            physics.drawDebug(camera.combined);
        }

        batch.setProjectionMatrix(camera.combined);
        overlay.render(delta);
    }

    public void resize(int width, int height) {
        camera.resize(width, height);
    }

    public void dispose() {
        batch.dispose();
        physics.dispose();
    }

    /**
     * Assumes the only entity with an InputComponent is the player
     */
    public Entity getPlayer() {
        return getFirstEntityFor(Family.all(InputComponent.class).get());
    }
}
