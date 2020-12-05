package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	Sound soundIn, soundOut;
	Music music;
	Texture personTexture;
	Ator principal;
	Random rand = new Random();

	List<Inimigo> inimigos = new ArrayList<Inimigo>();

	int w, h;
	float x, y;
	public static final int SPEED = 10;

	@Override
	public void create () {
		batch = new SpriteBatch();
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();

		personTexture = new Texture("sphere.png");
		principal = new Personagem(this, personTexture,
				w / 2f - w / 2f,
				h / 2f - h / 2f
		);

		for (int i = 0; i < 5; i++){
			inimigos.add(new Inimigo(this, personTexture));
		}
	}

	private void execute () {
		principal.execute();
		for (Inimigo ini : inimigos) ini.execute();

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
//		else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
//			if (music.isPlaying()) {
//				music.stop();
//			} else {
//				music.play();
//			}
//			soundOut.play();
//		}
	}

	@Override
	public void render () {
		execute();
		Gdx.gl.glClearColor(0, 0.5f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		principal.draw(batch);
		for (Inimigo ini : inimigos) ini.draw(batch);
	}

	public static float clamp(float val, float min, float max) {
		if (val < 0) return min;
		else if (val > max) return max;
		else return val;
	}

	@Override
	public void dispose () {
		batch.dispose();
		personTexture.dispose();
		font.dispose();
		soundIn.dispose();
		soundOut.dispose();
		music.dispose();
	}
}