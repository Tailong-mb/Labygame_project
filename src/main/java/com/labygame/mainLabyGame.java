package com.labygame;

import com.labygame.front.CreditsScene;
import com.labygame.front.FightScene;
import com.labygame.front.GameScene;
import com.labygame.front.GeneralScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class mainLabyGame extends Application {
    public static final int MENU_SCENE = 0;
    public static final int GAME_SCENE = 1;
    public static final int FIGHT_SCENE = 2;
    public static final int CREDITS_SCENE = 3;

    public static final GeneralScene[] scenes = new GeneralScene[4];//Arrays.asList(new MenuScene(), new GameScene(), new FightScene(), new CreditsScene());

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        scenes[0] = null;
        scenes[1] = new GameScene();
        scenes[2] = new FightScene();
        scenes[3] = new CreditsScene();

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
