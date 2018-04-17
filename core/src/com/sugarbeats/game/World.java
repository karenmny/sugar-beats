package com.sugarbeats.game;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.math.Vector2;
import com.sugarbeats.game.entity.component.AnimationComponent;
import com.sugarbeats.game.entity.component.BoundsComponent;
import com.sugarbeats.game.entity.component.GravityComponent;
import com.sugarbeats.game.entity.component.MovementComponent;
import com.sugarbeats.game.entity.component.PlayerComponent;
import com.sugarbeats.game.entity.component.StateComponent;
import com.sugarbeats.game.entity.component.TextureComponent;
import com.sugarbeats.game.entity.component.TransformComponent;
import com.sugarbeats.service.AssetService;
import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Quynh on 4/11/2018.
 *
 * World logic (variables)
 */

public class World {
    public static final float WORLD_WIDTH = 10;
    public static final float WORLD_HEIGHT = 15 * 20;
    public static final int WORLD_STATE_RUNNING = 0;
    public static final int WORLD_STATE_GAME_OVER = 1;

    public static final Vector2 gravity = new Vector2(0, -12);
    private PooledEngine engine;
    public int state;


    public World (PooledEngine engine) {
        this.engine = engine;
    }

    public void create() {
        createPlayer(1);
        Entity player2 = createPlayer(2);

        //createCamera(player1);
        //createBackground();

        this.state = WORLD_STATE_RUNNING;
    }

    private Entity createPlayer(int playerNr){
        Entity entity = engine.createEntity();

        AnimationComponent animation = engine.createComponent(AnimationComponent.class);
        PlayerComponent player = engine.createComponent(PlayerComponent.class);
        BoundsComponent bounds = engine.createComponent(BoundsComponent.class);
        GravityComponent gravity = engine.createComponent(GravityComponent.class);
        StateComponent state = engine.createComponent(StateComponent.class);
        MovementComponent movement = engine.createComponent(MovementComponent.class);
        TransformComponent position = engine.createComponent(TransformComponent.class);
        TextureComponent texture = engine.createComponent(TextureComponent.class);

        animation.animations.put(PlayerComponent.STATE_PLAY, AssetService.character1);
        texture.region = AssetService.character2;
        bounds.bounds.width = PlayerComponent.WIDTH;
        bounds.bounds.height = PlayerComponent.HEIGHT;

        // state.set(
        if (playerNr == 1) {
            state.set(PlayerComponent.STATE_PLAY);
        } else if (playerNr == 2) {
            state.set(PlayerComponent.STATE_STANDBY);
        }

        // TODO: Give player positions (randomized)
        position.position.add(225.0f,100.0f,0.0f);

        entity.add(animation);
        entity.add(player);
        entity.add(bounds);
        entity.add(gravity);
        entity.add(state);
        entity.add(movement);
        entity.add(position);
        entity.add(texture);

        engine.addEntity(entity);

        return entity;
    }

    public void update(float delta) {
        if (state == WORLD_STATE_RUNNING)
            engine.update(delta);
    }
}
