package com.sugarbeats.service;

/**
 * Created by taphan on 11.04.2018.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sugarbeats.SugarBeats;

public class AssetService {
    //Size of the screen (Should these be public or private?)
    public static final int WIDTH = SugarBeats.WIDTH;
    public static final int HEIGHT = SugarBeats.HEIGHT;

    //Backgrounds for menu logic
    public static Texture mainMenu;
    public static Texture settingsMenu;
    public static Texture pauseMenu;
    public static Texture helpMenu;

    //Buttons for menu, with hitboxes
    public static Texture playBtn;
    public static Texture settingBtn;
    public static Texture helpBtn;
    public static Texture hsBtn;
    public static Texture acBtn;
    public static Texture mBtn;

    //TODO: Add logic for music/soundeffects on/off? Good for usability
    //TODO: Add a 'back'-button?


    //Backgrounds within the game
    public static TextureRegion background1;
    public static TextureRegion background2;
    public static TextureRegion background3;

    //Map within the game
    public static TextureRegion map1;
    public static TextureRegion map2;
    public static TextureRegion map3;

    //Characters
    public static TextureRegion character2;
    public static Animation<TextureRegion> character1;

    //Buttons within the game, with hitboxes
    public static Texture rightBtn;
    public static Texture leftBtn;
    public static Texture upBtn;
    public static Texture downBtn;
    public static Texture powerUp1Btn;
    public static Texture powerUp2Btn;
    public static Texture powerBar;
    public static Texture powerBarBtn;
    public static Texture fireBtn;
    public static Texture pauseBtn;

    //Animations
    public static Animation walkAnim;
    public static Animation shootAnim;
    public static Animation projectimeAnim;
    public static Animation explosionAnim;
    public static Animation getHitAnim;
    public static Animation deathAnim;



    public static Texture loadTexture (String file) { //For loading multiple textures for text regions
        return new Texture(Gdx.files.internal(file));
    }

    public static void load () {
        //Graphics logic
        mainMenu = new Texture("main_menu.png");
        settingsMenu = new Texture("main_menu.png"); //TODO: make more menus?
        pauseMenu = new Texture("main_menu.png");
        helpMenu = new Texture("main_menu.png");

        playBtn = new Texture("button_play.png");
        settingBtn = new Texture("button_settings.png");
        helpBtn = new Texture("button_help.png");
        hsBtn = new Texture("button_highscore.png");
        acBtn = new Texture("button_achievements.png");
        mBtn = new Texture("button_multiplayer.png");

        map1 = new TextureRegion(loadTexture("ground1.png"));
        background1 = new TextureRegion(loadTexture("map1.png"));
        background2 = new TextureRegion(loadTexture("map2.png"));

        //character2 = new TextureRegion(new Texture("heliregion.png"),0,0,162,65);
        Texture heliLoad = loadTexture("character1.png");
        character1 = new Animation<TextureRegion>(0.2f,new TextureRegion(heliLoad,0,65),new TextureRegion(heliLoad,162,65));
        character2 = new TextureRegion(heliLoad, 0, 224, 300, 110);

        //TODO: add graphics and bounds for gameplay buttons
        fireBtn = new Texture("button_shoot.png");

        leftBtn = new Texture("back_button.png");
        rightBtn = new Texture("forward_button.png");

        //Animation logic
        //TODO: use the link below on how to make animations
        // https://github.com/saltares/ashley-superjumper/blob/master/core/src/com/siondream/superjumper/Assets.java
        //We might have to do it differently from them though, I suspect these animations run as an infinite loop regardless of user input
    }

}
