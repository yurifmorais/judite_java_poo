package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import static com.mygdx.game.Constants.*;

public class GameInput {

    public GameInput(World world, Player player) {
        world.setContactListener(new ListenerClass(player));
    }

    public void inputUpdate(Player player) {
        Body pBody = player.getBody();
        int horizontalVelocity = 0;

        if (globalState == GlobalState.MENU && Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            globalState = GlobalState.STORY;
        }
        if (globalState == GlobalState.STORY && Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            globalState = GlobalState.GAME;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && sideContact != LEFT_CONTACT) {
            horizontalVelocity--;
            player.setCurrentState(State.RUNNING_LEFT);
            rightHandSide = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && sideContact != RIGHT_CONTACT) {
            horizontalVelocity++;
            player.setCurrentState(State.RUNNING_RIGHT);
            rightHandSide = true;
        }
        if (horizontalVelocity == 0) {
            player.setCurrentState(State.IDLE);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && playerOnGround) {
            pBody.applyForceToCenter(0, 600, false);
        }
        pBody.setLinearVelocity(horizontalVelocity * 5, pBody.getLinearVelocity().y);

        if (player.getBody().getPosition().x >= 503 + PLAYER_WIDTH / 64f || player.getBody().getPosition().y < 2) {
            globalState = GlobalState.END;
        }
    }
}
