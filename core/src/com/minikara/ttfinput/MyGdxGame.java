package com.minikara.ttfinput;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class MyGdxGame extends ApplicationAdapter {
	Image img;
	
//	BitmapFont font12;
	
	protected Stage stage;

	
	private ScalingViewport viewport;
	
	private Skin skin;
	
	
	@Override
	public void create () {
		
		viewport = new ScalingViewport(Scaling.stretch, 320, 480);
		//		ScalingViewport viewport = new ScalingViewport(Scaling.fit, w, h);
		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(new InputMultiplexer(new InputProcessor(){

			@Override
			public boolean keyDown(int keycode) {
				Gdx.app.log("input", "keyDown:"+keycode);
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				Gdx.app.log("input", "keyUp:"+keycode);
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				Gdx.app.log("input", "keyTyped:"+character);
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}}, stage));

		img = new Image(new Texture(Gdx.files.internal("badlogic.jpg")));
		
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		
//		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("lanting.ttf"));
//		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
//		parameter.size = 90;
//		parameter.characters = "���FONT";
//		font12 = generator.generateFont(parameter); // font size 12 pixels
//		generator.dispose(); // don't forget to dispose to avoid memory leaks!
		
		TextField tf = new TextField("hello, text", skin);
		tf.setBounds(10, 200, 200, 40);
		TTFInput tfChinese = new TTFInput("你好中文", skin.get(com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle.class), Gdx.files.internal("lanting.TTF"));
		tfChinese.setBounds(10, 250, 200, 40);

		stage.addActor(img);
		stage.addActor(tf);
		stage.addActor(tfChinese);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
//		font12.draw(batch, "���GDXFONT", 22, 122);
	}

	@Override
	public void dispose() {
		skin.dispose();
		stage.dispose();
//		font12.dispose();
		super.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);

	}
}
