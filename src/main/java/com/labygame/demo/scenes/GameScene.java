package com.labygame.demo.scenes;

import com.labygame.demo.Labygame;
import com.labygame.demo.items.Item;
import com.labygame.demo.personnage.CharacterState;
import com.labygame.demo.personnage.Hero;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.util.HashMap;

import static com.labygame.demo.Labygame.CREDITS_SCENE;

public class GameScene extends GeneralScene{

    private Image background;
    private Hero hero;

    public GameScene(){
        super();
        try{
            background = new Image("file:doc/images/grass_template.jpg");
            hero = new Hero(50, CharacterState.NORMAL,"TheChosenOne",20,30,30,new HashMap<Item,Integer>());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw() {
        activeKeys.clear();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.drawImage(background,0,0,GAME_WIDTH,GAME_HEIGHT);
                gc.drawImage(hero.getMyImage(),0,0,16,30,250,250,48,90);
                
                if(activeKeys.contains(KeyCode.ESCAPE)){
                    this.stop();
                    Labygame.exit();
                    //Labygame.setScene(Labygame.MENU_SCENE);
                }
                if(activeKeys.contains(KeyCode.SPACE)){
                    this.stop();
                    Labygame.setScene(CREDITS_SCENE);
                }
            }
        };timer.start();
    }
}
