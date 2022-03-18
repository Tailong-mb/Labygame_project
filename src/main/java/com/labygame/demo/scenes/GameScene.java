package com.labygame.demo.scenes;

import com.labygame.demo.Labygame;
import javafx.scene.input.KeyCode;

public class GameScene extends GeneralScene{

    @Override
    public void draw() {
        activeKeys.clear();

        if(activeKeys.contains(KeyCode.ESCAPE)){
            Labygame.exit();
            //Labygame.setScene(Labygame.MENU_SCENE);
        }
    }
}
