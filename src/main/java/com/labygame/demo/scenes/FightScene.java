package com.labygame.demo.scenes;

import com.labygame.demo.mainLabyGame;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

import static com.labygame.demo.mainLabyGame.GAME_SCENE;

public class FightScene extends GeneralScene{
    @Override
    public void draw() {
        activeKeys.clear();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                if(activeKeys.contains(KeyCode.BACK_SPACE)){
                    this.stop();
                    mainLabyGame.setScene(GAME_SCENE);
                }
            }
        };timer.start();
    }
}
