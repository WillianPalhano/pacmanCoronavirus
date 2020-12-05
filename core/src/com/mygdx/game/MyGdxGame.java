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

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	Sound soundIn, soundOut;
	Music music;
	Texture personTexture;
	Personagem personagem;
	int w, h;
	float x, y;
	public static final int SPEED = 10;

	@Override
	public void create () {
		batch = new SpriteBatch();
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		System.out.println("Width e Height:" + Gdx.graphics.getWidth() + " " + Gdx.graphics.getHeight());
		personTexture = new Texture("sphere.png");
		personagem = new Personagem(this, personTexture,
				w / 2f - w / 2f,
				h / 2f - h / 2f
		);
		//Musicas
		font = new BitmapFont(
				Gdx.files.internal("verdana.fnt"),
				Gdx.files.internal("verdana.png"), false);
//		soundIn = Gdx.audio.newSound(Gdx.files.internal("in.wav"));
//		soundOut = Gdx.audio.newSound(Gdx.files.internal("out.wav"));
//		music = Gdx.audio.newMusic(Gdx.files.internal("otomata_music.ogg"));
//		soundIn.play();
//		music.setLooping(true);
//		music.play();
	}

	private void execute () {
		personagem.execute();

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
		personagem.draw(batch);
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