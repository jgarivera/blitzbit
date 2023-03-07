package com.blitzbit.core.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;

public class SpriteComponent implements Component {

    public int zIndex = 0;

    public String textureFilename;

    public SpriteComponent(String textureFilename) {
        this.textureFilename = textureFilename;
    }

    public SpriteComponent(String textureFilename, int zIndex) {
        this(textureFilename);
        this.zIndex = zIndex;
    }
}
