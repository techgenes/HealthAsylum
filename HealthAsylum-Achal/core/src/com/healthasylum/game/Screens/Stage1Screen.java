package com.healthasylum.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.healthasylum.game.HealthAsylum;
import com.healthasylum.game.scenes.Hud;

import javax.swing.text.TabExpander;

/**
 * Created by achalgupta on 3/16/2016.
 */
public class Stage1Screen implements Screen {
    private HealthAsylum game;
    private Hud hud;

    private OrthographicCamera gameCam;
    private Viewport gamePort;

    public Stage1Screen(HealthAsylum game) {// It took HealthAsylum as arguments so that all the rendering of HealthAsylum can be done from here
        this.game=game;
        gameCam=new OrthographicCamera();
        gamePort=new StretchViewport(HealthAsylum.V_WIDTH,HealthAsylum.V_HEIGHT,gameCam);// StretchViewport adjusts itself according to size of screen
        hud=new Hud(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,1,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        game.batch.begin();//draws on the batch of HealthAsylum
//        game.batch.draw(texture,0,0);
//        game.batch.end();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {//called whenever screen size is changed
        gamePort.update(width,height);//updates viewport whenever screen is resized
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
