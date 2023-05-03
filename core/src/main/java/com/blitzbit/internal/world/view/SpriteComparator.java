package com.blitzbit.internal.world.view;

import com.badlogic.ashley.core.Entity;
import com.blitzbit.internal.world.view.components.ViewComponentMapper;

import java.util.Comparator;

public class SpriteComparator implements Comparator<Entity> {

    @Override
    public int compare(Entity e1, Entity e2) {
        return ViewComponentMapper.SPRITE.get(e1).zIndex - ViewComponentMapper.SPRITE.get(e2).zIndex;
    }
}
