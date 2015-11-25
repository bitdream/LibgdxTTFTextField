package com.minikara.ttfinput;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;

public class TTFInput extends TextField{
	
	private FreeTypeFontGenerator generator;
	
	private FreeTypeFontParameter parameter = new FreeTypeFontParameter();
	
	private BitmapFont font;

	public TTFInput(String text, TextFieldStyle style, FileHandle ttf) {
		super(text, style);
		generator = new FreeTypeFontGenerator(ttf);
//		this.getStyle();
//		this.setStyle(style);
		
		updateFont(text);
		setText(text);

		this.setTextFieldListener(new TextFieldListener(){

			@Override
			public void keyTyped(TextField textField, char c) {
				Gdx.app.log("ttf", "typed:"+c);
				long tick = System.currentTimeMillis();
				updateFont(""+c);
				tick = System.currentTimeMillis() - tick;
				Gdx.app.log("ttf", "new font:"+tick+"ms"+":"+displayText);

				addAction(Actions.delay(2f, Actions.run(new Runnable(){

					@Override
					public void run() {
						updateDisplayText();
						invalidate();						
					}})));

			}});
		
	}
	
	public void updateFont(String newChars) {
		parameter.characters = parameter.characters + newChars;
		font = generator.generateFont(parameter);
//		generator.generateData(parameter);
		
		BitmapFont oldFont = this.getStyle().font;
		this.getStyle().font = this.getStyle().messageFont = font;
		oldFont.dispose();
		updateDisplayText();
	}
	
	
	
	public void dispose() {
		generator.dispose();
		font.dispose();
	}
	
	

}
