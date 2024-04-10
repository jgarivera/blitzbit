package com.jgarivera.blitzbit.world;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jgarivera.blitzbit.files.GameAssetManager;
import com.jgarivera.blitzbit.graphics.GameCamera;
import com.jgarivera.blitzbit.graphics.GameOverlay;
import com.jgarivera.blitzbit.input.GameActionManager;
import com.jgarivera.blitzbit.input.GameToggleManager;
import com.jgarivera.blitzbit.world.npcs.entities.Minion;
import com.jgarivera.blitzbit.world.physics.GamePhysics;
import com.jgarivera.blitzbit.world.physics.components.PhysicsBodyComponent;
import com.jgarivera.blitzbit.world.physics.components.PositionComponent;
import com.jgarivera.blitzbit.world.physics.listeners.PhysicsBodyListener;
import com.jgarivera.blitzbit.world.physics.systems.MovementSystem;
import com.jgarivera.blitzbit.world.player.components.InputComponent;
import com.jgarivera.blitzbit.world.player.entities.Player;
import com.jgarivera.blitzbit.world.player.listeners.PlayerActionListener;
import com.jgarivera.blitzbit.world.structures.entities.Flag;
import com.jgarivera.blitzbit.world.view.components.AnimatedSpriteComponent;
import com.jgarivera.blitzbit.world.view.listeners.AnimatedSpriteListener;
import com.jgarivera.blitzbit.world.view.systems.CameraSystem;
import com.jgarivera.blitzbit.world.view.systems.SpriteAnimationSystem;
import com.jgarivera.blitzbit.world.view.systems.SpriteOverlaySystem;
import com.jgarivera.blitzbit.world.view.systems.SpriteSystem;

public class GameWorld extends World {
    private final SpriteBatch batch;

    private final GameOverlay overlay;

    private final float WORLD_HEIGHT = 1280;
    private final float WORLD_WIDTH = 720;

    public GameWorld(GameAssetManager assetManager) {
        super(new Engine(), new GamePhysics(), new GameCamera(), new GameToggleManager(), assetManager);

        batch = new SpriteBatch();
        overlay = new GameOverlay(this);

        setupEngine();
        setupActionManager();

        addEntity(new Player(0, 0));
        addEntity(new Minion(5, 5));
        addEntity(new Minion(10, 10));
        addEntity(new Flag(11, 7));
    }

    private void setupEngine() {
        addSystem(new SpriteSystem(assetManager, batch));
        addSystem(new SpriteAnimationSystem(batch));
        addSystem(new SpriteOverlaySystem(this, batch));
        addSystem(new MovementSystem());
        addSystem(new CameraSystem(this));

        addEntityListenerFor(Family.all(PositionComponent.class, PhysicsBodyComponent.class).get(),
                new PhysicsBodyListener(physics));
        addEntityListenerFor(Family.all(AnimatedSpriteComponent.class).get(), new AnimatedSpriteListener(assetManager));
    }

    private void setupActionManager() {
        GameActionManager actionManager = new GameActionManager();
        actionManager.subscribe(new PlayerActionListener(this));

        Gdx.input.setInputProcessor(actionManager);
    }

    public void show() {

    }

    @Override
    public void update(float delta) {
        batch.begin();
        super.update(delta);
        batch.end();
    }

    public void render(float delta) {
        if (toggleManager.getToggle(GameToggleManager.DEBUG_MODE)) {
            physics.drawDebug(camera.combined);
        }

        batch.setProjectionMatrix(camera.combined);
    }

    public void renderOverlay(float delta) {
        overlay.render(delta);
    }

    public void resize(int width, int height) {
        camera.resize(width, height, GameCamera.VIEWPORT_WIDTH, GameCamera.VIEWPORT_HEIGHT);
        overlay.resize(width, height);
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
