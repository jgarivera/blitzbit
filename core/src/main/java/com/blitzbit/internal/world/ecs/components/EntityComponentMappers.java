package com.blitzbit.internal.world.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;

public class EntityComponentMappers {
    public static final ComponentMapper<PositionComponent> position = getFor(PositionComponent.class);
    public static final ComponentMapper<VelocityComponent> velocity = getFor(VelocityComponent.class);
    public static final ComponentMapper<SpeedComponent> speed = getFor(SpeedComponent.class);
    public static final ComponentMapper<SizeComponent> size = getFor(SizeComponent.class);
    public static final ComponentMapper<SpriteComponent> sprite = getFor(SpriteComponent.class);
    public static final ComponentMapper<ColorComponent> color = getFor(ColorComponent.class);
    public static final ComponentMapper<CameraFollowComponent> cameraFollow = getFor(CameraFollowComponent.class);

    public static final ComponentMapper<PhysicsBodyComponent> physics = getFor(PhysicsBodyComponent.class);

    public static <T extends Component> ComponentMapper<T> getFor(Class<T> componentClass) {
        return ComponentMapper.getFor(componentClass);
    }

    public static SizeComponent getSizeComponentOrDefault(Entity entity) {
        SizeComponent size = EntityComponentMappers.size.get(entity);

        if (size != null) {
            return size;
        } else {
            return new SizeComponent(32.0f, 32.0f);
        }
    }

    public static ColorComponent getColorComponentOrDefault(Entity entity) {
        ColorComponent color = EntityComponentMappers.color.get(entity);

        if (color != null) {
            return color;
        } else {
            return new ColorComponent(Color.WHITE);
        }
    }
}
