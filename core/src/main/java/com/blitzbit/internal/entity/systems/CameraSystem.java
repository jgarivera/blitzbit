package com.blitzbit.internal.entity.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.blitzbit.internal.entity.components.CameraFollowComponent;
import com.blitzbit.internal.entity.components.EntityComponentMappers;
import com.blitzbit.internal.entity.components.PositionComponent;
import com.blitzbit.internal.entity.components.SizeComponent;
import com.blitzbit.internal.graphics.GameCamera;
import com.blitzbit.api.input.action.ActionListener;
import com.blitzbit.internal.input.ActionType;
import com.blitzbit.internal.world.GameWorld;

public class CameraSystem extends IteratingSystem implements ActionListener {

    private final GameCamera camera;

    public CameraSystem(GameWorld world) {
        super(Family.all(CameraFollowComponent.class, PositionComponent.class, SizeComponent.class).get());
        camera = world.getCamera();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        CameraFollowComponent cameraFollow = EntityComponentMappers.cameraFollow.get(entity);

        if (!cameraFollow.shouldFollow) {
            return;
        }

        PositionComponent position = EntityComponentMappers.position.get(entity);
        SizeComponent size = EntityComponentMappers.size.get(entity);

        float followX = position.x;
        float followY = position.y;
        float interpolation = 0.2f;

        camera.followLerp(followX, followY, interpolation);
    }

    @Override
    public boolean onActionEntered(ActionType action) {
        if (action == ActionType.STOP_FOLLOW_CAMERA) {

        }

        return false;
    }

    @Override
    public boolean onActionExited(ActionType action) {
        return false;
    }
}
