package com.healthasylum.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.healthasylum.game.Screens.BonusLevelChestScreen;
import com.healthasylum.game.Screens.BonusLevelMouthScreen;
import com.healthasylum.game.Screens.Stage1Screen;

public class HealthAsylum extends Game { //THis class extends inbuilt Game class which implements application listener
	public static final int V_WIDTH=400;
	public static final int V_HEIGHT=208;

	public SpriteBatch batch;//It is public so that drawing on this batch can be done from outside Screen class
	
	@Override
	public void create () {//this function is called when application is created first time
		batch = new SpriteBatch();//this is container for our screen where all the images are drawn
		setScreen(new BonusLevelChestScreen(this));//inbuilt method in Game class it sets screen of our game whichever screen is passed to it

	}

	@Override
	public void render () {
		super.render();

	}
}
