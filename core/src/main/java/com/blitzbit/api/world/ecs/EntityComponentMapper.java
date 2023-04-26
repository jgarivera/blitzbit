package com.blitzbit.api.world.ecs;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;

public abstract class EntityComponentMapper {

    protected static <T extends Component> ComponentMapper<T> getFor(Class<T> componentClass) {
        return ComponentMapper.getFor(componentClass);
    }
}
