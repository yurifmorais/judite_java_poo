package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class GamePhysics {

    public GamePhysics() {
    }

    public BodyDef bodyDefCreate(float x, float y, boolean isDynamic) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(x, y);

        if (isDynamic) {
            bodyDef.type = BodyDef.BodyType.DynamicBody;
        } else {
            bodyDef.type = BodyDef.BodyType.StaticBody;
        }
        return bodyDef;
    }

    public void rectangularBodyCreate(World world, Rectangle rect, boolean isDynamic) {
        float bodyX = ((rect.getX() + rect.getWidth() / 2) / Constants.TILE_SIZE);
        float bodyY = ((rect.getY() + rect.getHeight() / 2) / Constants.TILE_SIZE);
        float bodyW = rect.getWidth() / (Constants.TILE_SIZE * 2);
        float bodyH = rect.getHeight() / (Constants.TILE_SIZE * 2);
        BodyDef bodyDef = bodyDefCreate(bodyX, bodyY, isDynamic);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(bodyW, bodyH);

        Body body = world.createBody(bodyDef);
        body.createFixture(shape, 1);

        shape.dispose();
    }
}