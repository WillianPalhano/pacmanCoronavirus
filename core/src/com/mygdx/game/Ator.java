package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ator {

    Sprite person;
    MyGdxGame game;

    public Ator(MyGdxGame game, Texture t, float x, float y){
        person = new Sprite(t);
        person.setPosition(x, y);
        this.game = game;
    }

    public void execute() {
        person.setPosition(
                MyGdxGame.clamp(person.getX(), 0, game.w - person.getWidth()),
                MyGdxGame.clamp(person.getY(), 0, game.h - person.getHeight()));
    }

    public void draw(SpriteBatch batch){
        batch.begin();
        person.draw(batch);
        batch.end();
    }

}
