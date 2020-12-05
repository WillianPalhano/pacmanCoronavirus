package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Tiro extends Ator {
    float direction;

    public Tiro(MyGdxGame game, Texture t, float x, float y, float direction) {
        super(game, t, x, y);
        this.direction = direction;
    }

    @Override
    public void execute() {
        if (direction == 0) {
            person.translateY(MyGdxGame.SPEED + 2);
        } else if (direction == 1) {
            person.translateY(-MyGdxGame.SPEED + 2);
        }else  if (direction == 2) {
            person.translateX(-MyGdxGame.SPEED + 2);
        } else if (direction == 3) {
            person.translateX(MyGdxGame.SPEED + 2);
        }
        if (person.getY() > game.h || person.getX() > game.w || person.getX() < -20 || person.getY() < -20) morto = true;
        for (Ator a: game.inimigos) {
            if (colisao(a) && a instanceof Inimigo) {
                morto = true;
                a.morto = true;
                game.maxInimigos = game.maxInimigos + 2;
                game.placar++;
            }
        }
    }
}
