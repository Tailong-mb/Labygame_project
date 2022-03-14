package com.labygame.demo.scenes;

import com.labygame.demo.Labygame;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

import static com.labygame.demo.Labygame.GAME_SCENE;

public class CreditsScene extends GeneralScene{
    @Override
    public void draw() {
        activeKeys.clear();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                if(activeKeys.contains(KeyCode.SPACE)){
                    this.stop();
                    Labygame.exit();
                }
                if(activeKeys.contains(KeyCode.BACK_SPACE)){
                    this.stop();
                    Labygame.setScene(GAME_SCENE);
                }
            }
        };timer.start();
    }
}
