package com.sugarbeats.service;

/**
 * Created by taphan on 11.04.2018.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sugarbeats.SugarBeats;

import javax.xml.soap.Text;

public class AssetService {
    //Size of the screen (Should these be public or private?)
    public static final int WIDTH = SugarBeats.WIDTH;
    public static final int HEIGHT = SugarBeats.HEIGHT;

    //Backgrounds for menu logic
    public static Texture mainMenu;
    public static Texture settingsMenu;
    public static Texture pauseMenu;
    public static Texture helpMenu;

    //Title for setting and helo
    public static Texture title_Setting;
    public static Texture title_Help;

    //Buttons for menu, with hitboxes
    public static Texture playBtn;
    public static Texture settingBtn;
    public static Texture helpBtn;
    public static Texture hsBtn;
    public static Texture acBtn;
    public static Texture mBtn;

    //TODO: Add logic for music/soundeffects on/off? Good for usability
    //TODO: Add a 'back'-button?
    public static Texture unmute_btn;
    public static Texture mute_btn;


    //Backgrounds within the game
    public static TextureRegion background1;
    public static TextureRegion background2;
    public static TextureRegion background3;

    //Map within the game
    public static TextureRegion map1;
    public static TextureRegion map2;
    public static TextureRegion map3;

    //Characters
    //public static TextureRegion character1;
    public static Animation<TextureRegion> character2;
    public static Animation<TextureRegion> character1;
    public static Animation<TextureRegion> bullet;

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

    public static Animation walkAnim1;
    public static Animation shootAnim1;
    public static Animation projectileAnim1;
    //public static Animation explosionAnim1;
    public static Animation getHitAnim1;
    public static Animation deathAnim1;

    public static Animation walkAnim2;
    public static Animation shootAnim2;
    public static Animation projectileAnim2;
    public static Animation getHitAnim2;
    public static Animation deathAnim2;

    public static Animation walkAnim3;
    public static Animation shootAnim3;
    public static Animation projectileAnim3;
    public static Animation getHitAnim3;
    public static Animation deathAnim3;



    public static Texture loadTexture (String file) { //For loading multiple textures for text regions
        return new Texture(Gdx.files.internal(file));
    }

    public static void load () {
        //Graphics logic
        mainMenu = new Texture("main_menu1.png");

        settingsMenu = new Texture("settingsMenu.png"); //TODO: make more menus?
        pauseMenu = new Texture("main_menu1.png");
        helpMenu = new Texture("main_menu1.png");

        title_Setting = new Texture("title_Setting.png");
        title_Help = new Texture("title_help.png");

        unmute_btn = new Texture("unmute.png");
        mute_btn = new Texture("mute.png");


        playBtn = new Texture("button_play1.png");
        settingBtn = new Texture("button_settings1.png");
        helpBtn = new Texture("button_help1.png");
        hsBtn = new Texture("button_highscore1.png");
        acBtn = new Texture("button_achievements1.png");
        mBtn = new Texture("button_multiplayer1.png");

        map1 = new TextureRegion(loadTexture("ground1.png"));
        background1 = new TextureRegion(loadTexture("map1.png"));
        background2 = new TextureRegion(loadTexture("map2.png"));

        //character2 = new TextureRegion(new Texture("heliregion.png"),0,0,162,65);
        //character1 = new Animation<TextureRegion>(0.2f,new TextureRegion(wl,0,65),new TextureRegion(heliLoad,162,65));
        //character2 = new TextureRegion(walk, 1500, 0, 500, 500);
        /*
        walk = loadTexture("char1ani.png");
        character2 = new Animation<TextureRegion>(0.2f,
                new TextureRegion(walk, 0, 0, 500, 500),
                new TextureRegion(walk, 500, 0, 500, 500),
                new TextureRegion(walk, 1000, 0, 500, 500),
                new TextureRegion(walk, 1500, 0, 500, 500));
                */

        Texture walk = loadTexture("candyani.png");
        character2 = new Animation<TextureRegion>(0.2f,
                new TextureRegion(walk, 0, 0, 200, 200),
                new TextureRegion(walk, 200, 0, 200, 200),
                new TextureRegion(walk, 400, 0, 200, 200),
                new TextureRegion(walk, 600, 0, 200, 200),
                new TextureRegion(walk, 800, 0, 200, 200),
                new TextureRegion(walk, 1000, 0, 200, 200),
                new TextureRegion(walk, 1200, 0, 200, 200),
                new TextureRegion(walk, 1400, 0, 200, 200));


        Texture bullet = loadTexture("bullet.png");

        //TODO: add graphics and bounds for gameplay buttons
        fireBtn = new Texture("button_shoot.png");

        leftBtn = new Texture("back_button.png");
        rightBtn = new Texture("forward_button.png");

        //Animation logic
        //TODO: use the link below on how to make animations
        // https://github.com/saltares/ashley-superjumper/blob/master/core/src/com/siondream/superjumper/Assets.java
        //We might have to do it differently from them though, I suspect these animations run as an infinite loop regardless of user input

       character2.setPlayMode(Animation.PlayMode.LOOP);
    }


}
