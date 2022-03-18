package com.labygame;

import com.labygame.demo.scenes.*;

import com.labygame.personnage.CharacterState;
import com.labygame.personnage.Hero;
import com.labygame.personnage.Wizard;
import javafx.application.Application;
import javafx.stage.Stage;

public class mainLabyGame extends Application {
    public static final int MENU_SCENE = 0;
    public static final int GAME_SCENE = 1;
    public static final int FIGHT_SCENE = 2;
    public static final int CREDITS_SCENE = 3;
    public static final int GAMEOVER_SCENE = 2;

    public static final GeneralScene[] scenesController = {new MenuScene(),new FightScene(new Hero(50, CharacterState.NORMAL,"Jean",10,0,0),
            new Wizard(16, CharacterState.NORMAL,"Merlin",10,0,0)),
            new GameOverScene()};

    public static Stage stage;

    @Override
    public void start(Stage stage){
        mainLabyGame.stage = stage;

        stage.setTitle("LabyGame");
        setScene(GAMEOVER_SCENE);
        stage.show();


    }

    public static void setScene(int numScene) {
        stage.setScene(scenesController[numScene]);
        scenesController[numScene].draw();
    }

    public static void exit(){
        stage.hide();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}