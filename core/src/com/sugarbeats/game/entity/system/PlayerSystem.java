package com.sugarbeats.game.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.sugarbeats.game.World;
import com.sugarbeats.game.entity.component.HealthComponent;
import com.sugarbeats.game.entity.component.MovementComponent;
import com.sugarbeats.game.entity.component.PlayerComponent;
import com.sugarbeats.game.entity.component.PowerupComponent;
import com.sugarbeats.game.entity.component.StateComponent;
import com.sugarbeats.game.entity.component.TransformComponent;

/**
 * Created by Quynh on 4/12/2018.
 *
 * Player in the game world logic: Movement, player states (powerup)
 */

public class PlayerSystem extends IteratingSystem {
    // Group together the components that make up this system
    private static final Family family = Family.all(PlayerComponent.class,
            StateComponent.class,
            TransformComponent.class,
            MovementComponent.class,
            HealthComponent.class).get();

    private World world;

    private ComponentMapper<PlayerComponent> pm;
    private ComponentMapper<StateComponent> sm;
    private ComponentMapper<TransformComponent> tm;
    private ComponentMapper<MovementComponent> mm;
    private ComponentMapper<PowerupComponent> pwrm;


    public PlayerSystem(World world) {
        super(family);

        this.world = world;

        pm = ComponentMapper.getFor(PlayerComponent.class);
        sm = ComponentMapper.getFor(StateComponent.class);
        tm = ComponentMapper.getFor(TransformComponent.class);
        mm = ComponentMapper.getFor(MovementComponent.class);
    }

    // TODO: Finish all player logics (change states)
    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent t = tm.get(entity);
        StateComponent state = sm.get(entity);
        MovementComponent mov = mm.get(entity);
        PlayerComponent player = pm.get(entity);

        if (t.position.x < 0) {
            t.position.x = World.WORLD_WIDTH;
        }
        // Prevent player from going outside of the world's width
        if (t.position.x > World.WORLD_WIDTH) {
            t.position.x = 0;
        }
    }

    //TODO: powerup logic
    public void gainPowerup (Entity player, Entity powerup) {
        if (!family.matches(player)) return;

        StateComponent state = sm.get(player);
        PowerupComponent pwr = pwrm.get(player);
        // Set player state to outside of NORMAL?
        // If powerup = SPEED: multiply player's velocity by 1.25

        // If powerup = POWER: multiply player's damage by 1.25
    }
}
