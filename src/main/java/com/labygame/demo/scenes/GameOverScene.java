package com.labygame.demo.scenes;

import com.labygame.mainLabyGame;
import com.labygame.sound.Music;
import com.labygame.sound.MusicType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
        Image backgroundImage = new Image("file:doc/images/gameover.jpg",1200,600,false,false);
        Image ghost = new Image("file:doc/images/Dead.png", 400, 75, false, false);

        this.gameOverMusic.playMusic();

        //text with instruction
        Text myText  = new Text("Click to continue");
        myText.setFont(Font.font(20));
        myText.setFill(Color.GREY);
        myText.setTranslateY(-200);

        gc.drawImage(backgroundImage,0,0);
        gc.drawImage(ghost,390,400);


        //way to return to the main Menu
        setOnMouseClicked(event ->{
            mainLabyGame.setScene(0);
            gameOverMusic.stopMusic();
        });

        root.getChildren().addAll(myText);

    }
}
