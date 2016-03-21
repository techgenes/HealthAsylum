package com.healthasylum.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.healthasylum.game.HealthAsylum;
import com.healthasylum.game.util.Constants;

import javax.swing.text.View;

/**
 * Created by achalgupta on 3/21/2016.
 */
public class BonusLevelChestScreen implements Screen {
    private HealthAsylum game;
    private Texture virusImage;
    private Texture capsuleImage;
    private Texture lungsImage;
    private OrthographicCamera gameCam;
    private Viewport gamePort;


    public BonusLevelChestScreen(HealthAsylum game) {
        this.game = game;
        //virusImage=new Texture();
       gameCam=new OrthographicCamera(Constants.BONUS_LEVEL_2_VIEWPORT_WIDTH,Constants.BONUS_LEVEL_2_VIEWPORT_HEIGHT);
        gamePort=new StretchViewport(Constants.BONUS_LEVEL_2_VIEWPORT_WIDTH,Constants.BONUS_LEVEL_2_VIEWPORT_HEIGHT,gameCam);
        capsuleImage=new Texture("capsule.png");
        lungsImage=new Texture("lungs.png");
    }

    @Override
    public void show() {

    }

    public void update(){

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(gameCam.combined);
        game.batch.begin();
        game.batch.draw(lungsImage, -Constants.BONUS_LEVEL_2_VIEWPORT_WIDTH / 2, -Constants.BONUS_LEVEL_2_VIEWPORT_HEIGHT / 2, Constants.BONUS_LEVEL_2_VIEWPORT_WIDTH, Constants.BONUS_LEVEL_2_VIEWPORT_HEIGHT);
        game.batch.draw(capsuleImage,-Constants.BONUS_LEVEL_2_VIEWPORT_WIDTH/2,-Constants.BONUS_LEVEL_2_VIEWPORT_HEIGHT/2,10.0f,3f);
        game.batch.draw(capsuleImage,-Constants.BONUS_LEVEL_2_VIEWPORT_WIDTH/2+28f,-Constants.BONUS_LEVEL_2_VIEWPORT_HEIGHT/2,10.0f,3f);
       // game.batch.draw(capsuleImage,-2.5f+2.8f,-2.2f,1.0f,0.3f);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
