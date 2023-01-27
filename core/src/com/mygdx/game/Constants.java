package com.mygdx.game;

public class Constants {
    public static final int WORLD_WIDTH_TEXTS = 256;
    public static final int WORLD_HEIGHT_TEXTS = 128;
    public static final int WORLD_WIDTH = 32;
    public static final int WORLD_HEIGHT = 16;
    public static final int TILE_SIZE = 32;
    public static final int PLAYER_WIDTH = 32;
    public static final int PLAYER_HEIGHT = 36;
    public static final int SPRITE_WIDTH = 32;
    public static final int SPRITE_HEIGHT = 48;
    public static final int NO_CONTACT = 0;
    public static final int LEFT_CONTACT = 1;
    public static final int RIGHT_CONTACT = 2;
    public static int sideContact = NO_CONTACT;
    public static boolean playerOnGround = true;
    public static boolean rightHandSide = true;

    public enum State {IDLE, RUNNING_RIGHT, RUNNING_LEFT}

    ;

    public enum GlobalState {MENU, STORY, GAME, END}

    ;
    public static GlobalState globalState = GlobalState.MENU;
}
