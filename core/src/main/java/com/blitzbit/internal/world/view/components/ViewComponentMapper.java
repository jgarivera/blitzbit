package com.blitzbit.internal.world.view.components;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.blitzbit.api.world.ecs.EntityComponentMapper;

public class ViewComponentMapper extends EntityComponentMapper {

    public static final ComponentMapper<SizeComponent> SIZE = getFor(SizeComponent.class);
    public static final ComponentMapper<SpriteComponent> SPRITE = getFor(SpriteComponent.class);
    public static final ComponentMapper<ColorComponent> COLOR = getFor(ColorComponent.class);
    public static final ComponentMapper<CameraFollowComponent> CAMERA_FOLLOW = getFor(CameraFollowComponent.class);

    public static SizeComponent getSizeComponentOrDefault(Entity entity) {
        SizeComponent size = ViewComponentMapper.SIZE.get(entity);

        if (size != null) {
            return size;
        } else {
            return new SizeComponent(32.0f, 32.0f);
        }
    }

    public static ColorComponent getColorComponentOrDefault(Entity entity) {
        ColorComponent color = ViewComponentMapper.COLOR.get(entity);

        if (color != null) {
            return color;
        } else {
            return new ColorComponent(Color.WHITE);
        }
    }
}
