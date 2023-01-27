package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.OrthographicCamera;

import static com.mygdx.game.Constants.*;

public class PPJogo extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Player player;
    private GameMap gMap;
    private GameInput gInput;
    private SpriteBatch batch;
    private int frameCount = 0;
    private Menu menu;
    Vector3 v3;

    @Override
    public void create() {
        camera = new OrthographicCamera(WORLD_WIDTH_TEXTS, WORLD_HEIGHT_TEXTS);
        camera.setToOrtho(false, WORLD_WIDTH_TEXTS, WORLD_HEIGHT_TEXTS);
        gMap = new GameMap();
        player = new Player(gMap.getWorld());
        gInput = new GameInput(gMap.getWorld(), player);
        batch = new SpriteBatch();
        menu = new Menu();
        v3 = new Vector3();
    }

    @Override
    public void render() {
        frameCount++;
        if (frameCount >= 60) {
            frameCount = 0;
        }

        cameraUpdate();
        ScreenUtils.clear(0.4f, 0.71f, 1, 1);
        gInput.inputUpdate(player);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        if (GlobalState.GAME == globalState) {
            gMap.update(camera);
            gMap.renderGameMap();
            player.render(batch, frameCount);
        } else {
            menu.render(batch);
        }
        batch.end();
    }

    private void cameraUpdate() {
        if (globalState == GlobalState.GAME) {
            camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        } else if (globalState == GlobalState.END) {
            camera.setToOrtho(false, WORLD_WIDTH_TEXTS, WORLD_HEIGHT_TEXTS);
        }

        if (player.getBody().getPosition().x > 16 && player.getBody().getPosition().x < 496) {
            v3.x = player.getBody().getPosition().x;
        } else if (player.getBody().getPosition().x >= 496) {
            v3.x = 496;
        } else {
            v3.x = 16;
        }

        v3.y = 8;
        camera.position.set(v3);
        camera.update();
    }

    @Override
    public void dispose() {
        menu.dispose();
        gMap.dispose();
        batch.dispose();
    }
}
