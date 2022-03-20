package com.labygame.demo.scenes;

import com.labygame.sound.Music;
import com.labygame.sound.MusicType;
import javafx.scene.image.Image;

public class GameOverScene extends GeneralScene{

    Music gameOverMusic = new Music(MusicType.END);

    public GameOverScene() {
        super();
    }

    @Override
    public void draw() {

        //Reset Key
        activeKeys.clear();

        //Set backGround image game over
        Image backgroundImage = new Image("file:doc/images/gameover.jpg",1200,850,false,false);
        Image ghost = new Image("file:doc/images/Dead.png", 400, 300, false, false);

        this.gameOverMusic.playMusic();

        //text with instruction

        gc.drawImage(backgroundImage,0,0);
        gc.drawImage(ghost,390,400);

    }
}
