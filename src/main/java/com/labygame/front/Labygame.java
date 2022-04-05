package com.labygame.front;

import com.labygame.front.scenes.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Labygame extends Application {
    public static final int MENU_SCENE = 0;
    public static final int GAME_SCENE = 1;
    public static final int FIGHT_SCENE = 2;
    public static final int CREDITS_SCENE = 3;
    public static final int GAME_OVER_SCENE = 4;


    public static final GeneralScene[] scenes = {new MenuScene(),
            new GameScene(),
            new FightScene(),
            new CreditsScene(),
            new GameOverScene()};

    public static Stage stage;

    @Override
    public void start(Stage stage){
        Labygame.stage = stage;
        stage.setTitle("LabyGame");
        setScene(MENU_SCENE);
        stage.show();
    }

    public static void setScene(int numScene) {
        stage.setScene(scenes[numScene]);
        scenes[numScene].draw();
    }

    public static void exit(){
        stage.hide();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}