package com.labygame.demo;

import com.labygame.demo.scenes.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class Labygame extends Application {
    public static final int MENU_SCENE = 0;
    public static final int GAME_SCENE = 1;
    public static final int FIGHT_SCENE = 2;
    public static final int CREDITS_SCENE = 3;

    public static final GeneralScene[] scenes = Arrays.asList(new MenuScene(), new GameScene(), new FightScene(), new CreditsScene());

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        stage.setTitle("LabyGame");
        setScene(GAME_SCENE);
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
