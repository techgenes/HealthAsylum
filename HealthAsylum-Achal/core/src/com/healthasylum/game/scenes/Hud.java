package com.healthasylum.game.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.healthasylum.game.HealthAsylum;

/**
 * Created by achalgupta on 3/17/2016.
 */
public class Hud {
    private Viewport viewport;//it has its own viewport because it will lock the hud on our screen
    public Stage stage;

    private int distance;
    public static int health;
    private int immunity;

    private Label distanceValueLabel;
    private Label healthValueLabel;
    private Label immunityValueLabel;
    private Label distanceLabel;
    private Label healthLabel;
    private Label immunityLabel;

    public Hud(SpriteBatch batch){
        distance=0;
        health=100;
        immunity=100;

        viewport=new FitViewport(HealthAsylum.V_WIDTH+300,HealthAsylum.V_HEIGHT+100,new OrthographicCamera());
        stage=new Stage(viewport);

        Table table=new Table();
        table.top();
        table.setFillParent(true);

        distanceValueLabel=new Label(String.format("%3d",distance),new Label.LabelStyle(new BitmapFont(), Color.PURPLE));
        healthValueLabel=new Label(String.format("%3d",health),new Label.LabelStyle(new BitmapFont(), Color.PURPLE));
        immunityValueLabel=new Label(String.format("%3d",immunity),new Label.LabelStyle(new BitmapFont(), Color.PURPLE));
        distanceLabel=new Label("Distance",new Label.LabelStyle(new BitmapFont(), Color.PURPLE));
        healthLabel=new Label("Health",new Label.LabelStyle(new BitmapFont(), Color.PURPLE));
        immunityLabel=new Label("Immunity",new Label.LabelStyle(new BitmapFont(), Color.PURPLE));

        //add elements to our table
        table.add(distanceLabel).expandX().padTop(10);//expandX() increases size of label to occupy width of its parent and padTop() provides padding at Top
        table.add(healthLabel).expandX().padTop(10);
        table.add(immunityLabel).expandX().padTop(10);
        table.row();//a new row is created
        table.add(distanceValueLabel).expandX();
        table.add(healthValueLabel).expandX();
        table.add(immunityValueLabel).expandX();
        //table is added to stage
        stage.addActor(table);
    }
}
