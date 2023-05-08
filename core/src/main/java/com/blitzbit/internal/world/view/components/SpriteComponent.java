package com.blitzbit.internal.world.view.components;

import com.badlogic.ashley.core.Component;

public class SpriteComponent implements Component {

    public String textureFilename;

    public SpriteComponent(String textureFilename) {
        this.textureFilename = textureFilename;
    }
}
