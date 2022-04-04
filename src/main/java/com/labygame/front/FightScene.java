package com.labygame.front;

import com.labygame.mainLabyGame;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

public class FightScene extends GeneralScene{
    @Override
    public void draw() {
        activeKeys.clear();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                if(activeKeys.contains(KeyCode.BACK_SPACE)){
                    this.stop();
                    mainLabyGame.setScene(mainLabyGame.GAME_SCENE);
                }
            }
        };timer.start();
    }
}
