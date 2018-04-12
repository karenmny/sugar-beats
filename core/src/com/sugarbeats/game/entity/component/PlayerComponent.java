package com.sugarbeats.game.entity.component;

import com.badlogic.ashley.core.Component;

/**
 * Created by Quynh on 4/11/2018.
 */

public class PlayerComponent implements Component{
    public static final int STATE_FALL = 0;
    public static final int STATE_HIT = 1;

    public static final float WIDTH = 0.8f;
    public static final float HEIGHT = 0.8f;
}