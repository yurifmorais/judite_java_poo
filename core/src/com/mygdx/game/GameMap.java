package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.*;
import com.badlogic.gdx.maps.objects.*;

public class GameMap {
    private final World world;
    private final TiledMap map;
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final GamePhysics gPhysics;

    public GameMap() {
        world = new World(new Vector2(0, -10), true);
        gPhysics = new GamePhysics();
        map = new TmxMapLoader().load("tileset/ground.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map, 1f / Constants.TILE_SIZE);
        embodyTiles(world, map);
    }

    public void update(OrthographicCamera camera) {
        mapRenderer.setView(camera);
        Batch bCam = mapRenderer.getBatch();
        bCam.setProjectionMatrix(camera.combined);
    }

    public World getWorld() {
        return world;
    }

    public void renderGameMap() {
        mapRenderer.render();
        world.step(1 / 60f, 6, 2);
    }

    private void embodyTiles(World world, TiledMap map) {
        MapObjects objects = map.getLayers().get("ground").getObjects();

        for (int i = 0; i < objects.getCount(); i++) {
            RectangleMapObject obj = (RectangleMapObject) objects.get(i);
            Rectangle rect = obj.getRectangle();
            gPhysics.rectangularBodyCreate(world, rect, false);
        }
    }
    public void dispose() {
        world.dispose();
        map.dispose();
        mapRenderer.dispose();
    }
}
