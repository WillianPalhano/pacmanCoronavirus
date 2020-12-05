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
	Texture personTexture;
	Random rand = new Random();
	int contadorInimigos = 0;
	int maxInimigos = 2;
	int placar = 0;
	String status = "";

	List<Ator> inimigos = new ArrayList<>();
	List<Tiro> news = new ArrayList<>();

	int w, h;
	float x, y;
	public static final int SPEED = 10;

	@Override
	public void create () {
		batch = new SpriteBatch();
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		font = new BitmapFont(
				Gdx.files.internal("verdana.fnt"),
				Gdx.files.internal("verdana.png"), false);
		personTexture = new Texture("sphere.png");
		inimigos.add(new Personagem(this, personTexture,
				w / 2f - w / 2f,
				h / 2f - h / 2f
		));
	}

	private void execute () {
		for (Ator ini : inimigos) ini.execute();
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		criarInimigos();
		limpar();
	}

	void criarInimigos(){
		if (contadorInimigos < maxInimigos){
			inimigos.add(new Inimigo(this, personTexture));
			contadorInimigos++;
			System.out.println("Contador / maximo: " + contadorInimigos + " / " + maxInimigos);
		}
	}

	void limpar(){
		List<Ator> aux = inimigos;
		inimigos = new ArrayList<Ator>();
		for (Ator i: aux) if (!i.morto) inimigos.add(i);
		inimigos.addAll(news);
		news.clear();
	}

	void atirar(float x, float y, float direction){
		news.add(new Tiro(this, personTexture,x , y, direction));
	}

	@Override
	public void render () {
		execute();
		Gdx.gl.glClearColor(0, 0.5f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, "Placar: " + placar, 1, h + 1);
		font.draw(batch, status, 300, h + 1);
		batch.end();
		for (Ator ini : inimigos) ini.draw(batch);
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
	}
}