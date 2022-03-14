package com.labygame.demo.scenes;

import com.labygame.demo.Labygame;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

public class GameScene extends GeneralScene{

    @Override
    public void draw() {
        activeKeys.clear();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                if(activeKeys.contains(KeyCode.ESCAPE)){
                    this.stop();
                    Labygame.exit();
                    //Labygame.setScene(Labygame.MENU_SCENE);
                }
            }
        };timer.start();
    }
}
