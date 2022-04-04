package com.labygame.front.scenes;

import com.labygame.front.Labygame;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

public class FightScene extends GeneralScene {
    @Override
    public void draw() {
        activeKeys.clear();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                if(activeKeys.contains(KeyCode.BACK_SPACE)){
                    this.stop();
                    Labygame.setScene(Labygame.GAME_SCENE);
                }
            }
        };timer.start();
    }
}
