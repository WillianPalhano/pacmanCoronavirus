package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Personagem {

    Sprite person;
    MyGdxGame game;

    public Personagem(MyGdxGame game, Texture t, float x, float y){
        person = new Sprite(t);
        person.setPosition(x, y);
        this.game = game;
    }

    public void execute() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && (person.getY() != game.h || person.getY() == 0)) {
            person.translateY(MyGdxGame.SPEED);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && (person.getY() == game.h || person.getY() != 0)) {
            person.translateY(-MyGdxGame.SPEED);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && (person.getX() == game.w || person.getX() != 0)) {
            person.translateX(-MyGdxGame.SPEED);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && (person.getX() != game.w || person.getX() == 0)) {
            person.translateX(MyGdxGame.SPEED);
        }
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
