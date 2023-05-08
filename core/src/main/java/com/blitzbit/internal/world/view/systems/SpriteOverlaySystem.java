package com.blitzbit.internal.world.view.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.blitzbit.internal.input.GameToggleManager;
import com.blitzbit.internal.world.GameWorld;
import com.blitzbit.internal.world.physics.components.PhysicsComponentMapper;
import com.blitzbit.internal.world.physics.components.PositionComponent;
import com.blitzbit.internal.world.view.RenderOrderComparator;
import com.blitzbit.internal.world.view.components.*;

public class SpriteOverlaySystem extends SortedIteratingSystem {

    private final GameWorld world;
    private final SpriteBatch batch;
    private final BitmapFont font;

    public SpriteOverlaySystem(GameWorld world, SpriteBatch batch) {
        super(Family.all(PositionComponent.class, RenderOrderComponent.class)
                .one(SpriteComponent.class, AnimatedSpriteComponent.class).get(), new RenderOrderComparator());
        this.world = world;
        this.batch = batch;

        font = new BitmapFont();
        font.setUseIntegerPositions(false);
        font.getData().setScale(0.01f);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        if (!isDebugMode()) {
            return;
        }

        PositionComponent position = PhysicsComponentMapper.POSITION.get(entity);
        SizeComponent size = ViewComponentMapper.getSizeComponentOrDefault(entity);

        float x = position.x;
        float y = position.y;
        float width = size.width;
        float height = size.height;
        float originX = width / 2.0f;
        float originY = height / 2.0f;
        String overlay = String.format("x=%.2fm,y=%.2fm\nw=%.2fm, h=%.2fm", x, y, width, height);

        font.draw(batch, overlay, x - originX, y - originY);
    }

    private boolean isDebugMode() {
        return world.getToggleManager().getToggle(GameToggleManager.DEBUG_MODE);
    }
}
