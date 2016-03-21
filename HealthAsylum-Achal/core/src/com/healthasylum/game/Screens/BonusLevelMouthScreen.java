package com.healthasylum.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.healthasylum.game.HealthAsylum;
import com.healthasylum.game.scenes.Hud;
import com.healthasylum.game.util.Constants;

import java.util.Random;

/**
 * Created by achalgupta on 3/21/2016.
 */
public class BonusLevelMouthScreen implements Screen {
    private HealthAsylum game;
    private OrthographicCamera gameCam;
    private Texture[] virusTextures;
    private Viewport gameport;
    private Texture virusImage;
    private Texture virus2Image;
    private Texture virus3Image;
    private Texture brushImage;
    private Texture mouthImage;
    private int time=0;
    private int i=0;
    private Screen previousScreen;
    public static Random rand=new Random();
    float virusPosX,virusPosY;
    float brushPosX,brushPosY;
    private Vector3 cordinates;
    Rectangle virusRect;
    Rectangle brushRect;
    private Sprite spr;

    public BonusLevelMouthScreen(HealthAsylum game) {
        this.game = game;
        gameCam=new OrthographicCamera(Constants.BONUS_LEVEL_1_VIEWPORT_WIDTH,Constants.BONUS_LEVEL_1_VIEWPORT_HEIGHT);
        gameCam.position.set(0,0,0);
        gameport=new StretchViewport(Constants.BONUS_LEVEL_1_VIEWPORT_WIDTH,Constants.BONUS_LEVEL_1_VIEWPORT_HEIGHT,gameCam);

        virusImage=new Texture("virus.png");
        virus2Image=new Texture("virus2.png");
        virus3Image=new Texture("virus3.png");

        virusTextures=new Texture[3];
        virusTextures[0]=virusImage;
        virusTextures[1]=virus2Image;
        virusTextures[2]=virus3Image;
        mouthImage=new Texture("mouth.png");
        brushImage=new Texture("brush.png");
        cordinates=new Vector3(0,0,0);

        //virusPosX=gameport.getScreenX()+HealthAsylum.V_WIDTH/2;
        //virusPosY=gameport.getScreenY()+HealthAsylum.V_HEIGHT/2;
       virusPosX=0;
        virusPosY=0;
        brushPosX= Gdx.input.getX()/Gdx.graphics.getWidth()*Constants.BONUS_LEVEL_1_VIEWPORT_WIDTH;
        brushPosY=Gdx.input.getY()/Gdx.graphics.getHeight()*Constants.BONUS_LEVEL_1_VIEWPORT_HEIGHT;

        virusRect=new Rectangle(virusPosX,virusPosY,virusImage.getWidth(),virusImage.getHeight());
        brushRect=new Rectangle(brushPosX,brushPosY,brushImage.getWidth()/10,brushImage.getHeight());
        spr=new Sprite(virusImage);
        spr.setSize(1.0f,1.0f);

    }

    @Override
    public void show() {

    }

    public void update(float delta){//update coordinates of brush image and brushrectangle and virusrectangle
        brushPosX=(float)(Gdx.input.getX())/Gdx.graphics.getWidth()*Constants.BONUS_LEVEL_1_VIEWPORT_WIDTH-Constants.BONUS_LEVEL_1_VIEWPORT_WIDTH/2-((float)brushImage.getWidth()/(10*Gdx.graphics.getWidth()));
        brushPosY=(float)(-Gdx.input.getY())/Gdx.graphics.getHeight()*Constants.BONUS_LEVEL_1_VIEWPORT_HEIGHT-Constants.BONUS_LEVEL_1_VIEWPORT_HEIGHT/2+Constants.BONUS_LEVEL_1_VIEWPORT_WIDTH-((float)brushImage.getHeight()/(3*Gdx.graphics.getHeight()));

        virusRect=spr.getBoundingRectangle();
        brushRect.setPosition(brushPosX, brushPosY);
        brushRect.setSize((float) brushImage.getWidth() / (5 * Gdx.graphics.getWidth()), (float) brushImage.getHeight() / Gdx.graphics.getHeight());

    }



    public void updateVirus(float delta){
        float rotation=spr.getRotation();
        rotation+=90*delta;
        rotation=rotation%360;
        spr.setRotation(rotation);
        virusRect=spr.getBoundingRectangle();
           }

    private void handleInput(float delta){

        if(Gdx.input.justTouched()) {
     //       System.out.println(virusRect.getX() + " " + virusRect.getWidth() + " " + brushRect.getX() + " " + brushRect.getWidth());
            if(virusRect.overlaps(brushRect)){
                i++;
                System.out.print("I am touched"+i);
                Hud.health+=5;
            }
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        if (time % 80 == 0) {
            virusPosX = MathUtils.random(-1.5f,1.5f);
            virusPosY = MathUtils.random(-1.5f,1.5f);;
            virusRect.setPosition(virusPosX, virusPosY);
            spr.setTexture(virusTextures[rand.nextInt(3)]);
        }
        game.batch.setProjectionMatrix(gameCam.combined);
        game.batch.draw(mouthImage, -Constants.BONUS_LEVEL_1_VIEWPORT_WIDTH / 2, -Constants.BONUS_LEVEL_1_VIEWPORT_HEIGHT / 2, Constants.BONUS_LEVEL_1_VIEWPORT_WIDTH, Constants.BONUS_LEVEL_1_VIEWPORT_HEIGHT);
        spr.setPosition(virusPosY, virusPosX);
        spr.draw(game.batch);

        update(delta);
        game.batch.draw(brushImage, brushPosX, brushPosY, 2.0f, 1.0f);
        game.batch.end();
        time++;
        handleInput(delta);

    }
    @Override
    public void resize(int width, int height) {
//        gameCam.viewportWidth=(Constants.BONUS_LEVEL_1_VIEWPORT_HEIGHT/height)*width;
//        gameCam.update();
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
