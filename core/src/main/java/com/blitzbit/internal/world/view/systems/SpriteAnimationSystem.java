package com.blitzbit.internal.world.view.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.blitzbit.api.files.AssetManager;
import com.blitzbit.internal.world.physics.components.PhysicsComponentMapper;
import com.blitzbit.internal.world.physics.components.PositionComponent;
import com.blitzbit.internal.world.view.RenderOrderComparator;
import com.blitzbit.internal.world.view.components.AnimatedSpriteComponent;
import com.blitzbit.internal.world.view.components.SizeComponent;
import com.blitzbit.internal.world.view.components.ViewComponentMapper;

public class SpriteAnimationSystem extends SortedIteratingSystem {

    private final AssetManager assetManager;
    private final SpriteBatch batch;

    public SpriteAnimationSystem(AssetManager assetManager, SpriteBatch batch) {
        super(Family.all(AnimatedSpriteComponent.class, PositionComponent.class).get(), new RenderOrderComparator());
        this.assetManager = assetManager;
        this.batch = batch;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = PhysicsComponentMapper.POSITION.get(entity);
        AnimatedSpriteComponent animatedSprite = ViewComponentMapper.ANIMATED_SPRITE.get(entity);
        SizeComponent size = ViewComponentMapper.getSizeComponentOrDefault(entity);

        animatedSprite.stateTime += deltaTime;

        TextureRegion texture = animatedSprite.animation.getKeyFrame(animatedSprite.stateTime, true);

        float x = position.x;
        float y = position.y;
        float width = size.width;
        float height = size.height;
        float originX = width / 2.0f;
        float originY = height / 2.0f;

        batch.draw(texture, x - originX, y - originY, width, height);
    }
}
