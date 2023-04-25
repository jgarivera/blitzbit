package com.blitzbit.internal.world;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.blitzbit.api.world.World;
import com.blitzbit.internal.files.GameAssetManager;
import com.blitzbit.internal.graphics.GameCamera;
import com.blitzbit.internal.graphics.GameOverlay;
import com.blitzbit.internal.input.GameActionManager;
import com.blitzbit.internal.input.GameToggleManager;
import com.blitzbit.internal.world.npcs.entities.Minion;
import com.blitzbit.internal.world.physics.GamePhysics;
import com.blitzbit.internal.world.physics.components.PhysicsBodyComponent;
import com.blitzbit.internal.world.physics.components.PositionComponent;
import com.blitzbit.internal.world.physics.listeners.PhysicsBodyListener;
import com.blitzbit.internal.world.physics.systems.MovementSystem;
import com.blitzbit.internal.world.player.components.InputComponent;
import com.blitzbit.internal.world.player.entities.Player;
import com.blitzbit.internal.world.player.listeners.PlayerActionListener;
import com.blitzbit.internal.world.structures.entities.Flag;
import com.blitzbit.internal.world.view.systems.CameraSystem;
import com.blitzbit.internal.world.view.systems.SpriteSystem;

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

        PlayerActionListener playerActionListener = new PlayerActionListener(this);
        GameActionManager actionManager = new GameActionManager();
        actionManager.subscribe(playerActionListener);

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
