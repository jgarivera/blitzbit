package com.blitzbit.core.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

public class EntityComponentMappers {
    public static final ComponentMapper<PositionComponent> position = getFor(PositionComponent.class);
    public static final ComponentMapper<VelocityComponent> velocity = getFor(VelocityComponent.class);
    public static final ComponentMapper<SizeComponent> size = getFor(SizeComponent.class);
    public static final ComponentMapper<SpriteComponent> sprite = getFor(SpriteComponent.class);
    public static final ComponentMapper<ColorComponent> color = getFor(ColorComponent.class);
    public static final ComponentMapper<CameraFollowComponent> cameraFollow = getFor(CameraFollowComponent.class);

    public static final ComponentMapper<PhysicsComponent> physics = getFor(PhysicsComponent.class);

    public static <T extends Component> ComponentMapper<T> getFor(Class<T> componentClass) {
        return ComponentMapper.getFor(componentClass);
    }
}
