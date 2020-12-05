package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Inimigo extends Ator {

    int direction;
    int step;
    int maxStep;

    public Inimigo(MyGdxGame game, Texture t) {
        super(game, t, game.rand.nextInt(game.w), game.rand.nextInt(game.h));
        maxStep = 10 + game.rand.nextInt(10);
        direction = game.rand.nextInt(8);
    }

    @Override
    public void execute() {
        step++;
        if (step > maxStep){
            direction = game.rand.nextInt(8);
            maxStep = 5 + game.rand.nextInt(10);
            step = 0;
        }
        switch (direction){
            //Baixo
            case 0:
                if (person.getY() != game.w || person.getY() == 0){
                    person.translateY(-5);
                }
                break;
            //Cima
            case 1:
                if (person.getY() == game.w || person.getY() != 0){
                    person.translateY(5);
                }
                break;
            //Direita
            case 2:
                if (person.getX() == game.h || person.getX() != 0){
                    person.translateX(5);
                }
                break;
            //Esquerda
            case 3:
                if (person.getX() != game.h || person.getX() == 0){
                    person.translateX(-5);
                }
                break;
            //Baixo - Esquerda
            case 4:
                if ((person.getY() != game.w || person.getY() == 0 || person.getX() != game.h || person.getX() == 0)){
                    person.translateY(-5);
                    person.translateX(-5);
                }
                break;
            //Baixo - Direita
            case 5:
                if (person.getY() != game.w || person.getY() == 0  || person.getX() == game.h || person.getX() != 0){
                    person.translateY(-5);
                    person.translateX(5);
                }
                break;
            //Cima - Esquerda
            case 6:
                if (person.getY() == game.w || person.getY() != 0 || person.getX() != game.h || person.getX() == 0){
                    person.translateY(5);
                    person.translateX(-5);
            }
                break;
            //Cima - Direita
            case 7:
                if (person.getY() == game.w || person.getY() != 0 || person.getX() == game.h || person.getX() != 0){
                    person.translateY(5);
                    person.translateX(5);
                }
                break;

        }
        super.execute();
    }
}
