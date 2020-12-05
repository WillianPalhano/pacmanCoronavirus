package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Personagem extends Ator {
    public Personagem(MyGdxGame game, Texture t, float x, float y) {
        super(game, t, x, y);
    }

    @Override
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
        super.execute();
    }
}
