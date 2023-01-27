package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.mygdx.game.Constants.*;

public class Menu {
    BitmapFont font32, font18;

    public Menu() {
        bitmapCreate();
    }

    public void render(Batch batch) {
        if (GlobalState.MENU == globalState) {
            font32.draw(batch, "A Bruxa Judite!", -52, 30);
            font18.draw(batch, "Pressione ENTER para continuar.", -72, -14);

        } else if (GlobalState.STORY == globalState) {
            font18.draw(batch, "Judite saiu para colher cogumelos,\nmas acabou se perdendo.\nAjude-a a encontrar sua casa!", -76, 40);
            font18.draw(batch, "Pressione seta direita para continuar.", -82, -28);
        } else if (GlobalState.END == globalState) {
            font18.draw(batch, "Judite se perdeu!", -56, 40);
        }
    }

    private void bitmapCreate() {
        Texture texture = new Texture(Gdx.files.internal("fonts/silver32.png"), true);
        texture.setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear);
        font32 = new BitmapFont(Gdx.files.internal("fonts/silver32.fnt"), new TextureRegion(texture), false);
        texture = new Texture(Gdx.files.internal("fonts/silver18.png"), true);
        font18 = new BitmapFont(Gdx.files.internal("fonts/silver18.fnt"), new TextureRegion(texture), false);
        font32.getData().setScale(0.6f);
        font18.getData().setScale(0.6f);
    }
    public void dispose() {
    }
}