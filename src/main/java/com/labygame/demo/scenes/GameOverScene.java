package com.labygame.demo.scenes;

import com.labygame.mainLabyGame;
import com.labygame.menu.button;
import com.labygame.sound.Music;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class GameOverScene extends GeneralScene{

    Music gameOverMusic = new Music();

    public GameOverScene() {
        super();
    }

    @Override
    public void draw() {

        //Reset Key
        activeKeys.clear();

        //Set backGround image game over
        Image backgroundImage = new Image("file:doc/images/gameover.jpg",1200,600,false,false);
        Image ghost = new Image("file:doc/images/Dead.png", 400, 75, false, false);

        gameOverMusic.playGameOverMusic();

        gc.drawImage(backgroundImage,0,0);
        gc.drawImage(ghost,390,400);

        button btnReturn = new button("Return");
        btnReturn.setOnMouseClicked(event ->{
            mainLabyGame.setScene(0);
        });
        btnReturn.setTranslateY(-250);
        btnReturn.setTranslateX(-400);

        root.getChildren().addAll(btnReturn);

    }
}
