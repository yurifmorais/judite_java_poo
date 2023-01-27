package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.*;

import static com.mygdx.game.Constants.*;

public class ListenerClass implements ContactListener {
    private Player player;
    private Fixture fA, fB;

    public ListenerClass(Player player) {
        this.player = player;
    }

    @Override
    public void beginContact(Contact contact) {
        fA = contact.getFixtureA();
        fB = contact.getFixtureB();

        if (fA.getUserData() != null && fA.getUserData().equals("foot")) {
            playerOnGround = true;
        }
        if (fB.getUserData() != null && fB.getUserData().equals("foot")) {
            playerOnGround = true;
        }
        if (fA.getUserData() != null && fA.getUserData().equals("head")) {
            playerOnGround = false;
        }
        if (fB.getUserData() != null && fB.getUserData().equals("head")) {
            playerOnGround = false;
        }
        if (fA.getUserData() != null && fA.getUserData().equals("left")) {
            sideContact = LEFT_CONTACT;
        }
        if (fB.getUserData() != null && fB.getUserData().equals("left")) {
            sideContact = LEFT_CONTACT;
        }
        if (fA.getUserData() != null && fA.getUserData().equals("right")) {
            sideContact = RIGHT_CONTACT;
        }
        if (fB.getUserData() != null && fB.getUserData().equals("right")) {
            sideContact = RIGHT_CONTACT;
        }
    }

    @Override
    public void endContact(Contact contact) {
        fA = contact.getFixtureA();
        fB = contact.getFixtureB();

        if (fA.getUserData() != null && fA.getUserData().equals("foot")) {
            playerOnGround = false;
        }
        if (fB.getUserData() != null && fB.getUserData().equals("foot")) {
            playerOnGround = false;
        }
        if (fA.getUserData() != null && fA.getUserData().equals("left")) {
            sideContact = NO_CONTACT;
        }
        if (fB.getUserData() != null && fB.getUserData().equals("left")) {
            sideContact = NO_CONTACT;
        }
        if (fA.getUserData() != null && fA.getUserData().equals("right")) {
            sideContact = NO_CONTACT;
        }
        if (fB.getUserData() != null && fB.getUserData().equals("right")) {
            sideContact = NO_CONTACT;
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }
}
