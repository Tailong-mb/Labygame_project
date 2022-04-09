package com.labygame.front.scenes;

import com.labygame.Labygame;
import com.labygame.sound.Music;
import com.labygame.sound.MusicType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class GameOverScene extends GeneralScene{

    Music gameOverMusic = new Music(MusicType.END);
    private int positionGhostUp = -300;
    private int positionGhostMiddle = -200;
    private int positionGhostBot = 400;
    ImageView ghostUp = new ImageView(new Image("file:doc/images/gfx/gfx/gameOverScene/ghost.png"));
    ImageView ghostMiddle = new ImageView(new Image("file:doc/images/gfx/gfx/gameOverScene/ghost.png"));
    ImageView ghostBottom =  new ImageView(new Image("file:doc/images/gfx/gfx/gameOverScene/ghost.png"));
    ImageView ghostLeft =  new ImageView(new Image("file:doc/images/gfx/gfx/gameOverScene/ghost.png"));
    ImageView ghostBotLeft =  new ImageView(new Image("file:doc/images/gfx/gfx/gameOverScene/ghost.png"));

    public GameOverScene() {
        super();
    }

    @Override
    public void draw() {

        //Reset Key
        activeKeys.clear();

        //Play music
        gameOverMusic.playMusic();

        //Set backGround image game over
        Image backgroundImage = new Image("file:doc/images/gfx/gfx/gameOverScene/loseBackground.jpg",1200,850,false,false);

        //text with instruction
        gc.drawImage(backgroundImage,0,0);
        root.getChildren().addAll(ghostBottom, ghostMiddle, ghostUp, ghostLeft,ghostBotLeft);
        setRoot(root);

        //Set timer
        Timeline creditTimer = new Timeline(new KeyFrame(Duration.millis(50), this::doStep));
        creditTimer.setCycleCount(600);

        creditTimer.play();
    }

    private void doStep(ActionEvent actionEvent) {
        //remove ghost
        root.getChildren().removeAll(ghostUp, ghostMiddle, ghostBottom, ghostLeft,ghostBotLeft);

        //Set position ghost
        ghostUp.setTranslateX(positionGhostUp);
        ghostUp.setTranslateY(positionGhostUp);
        ghostBottom.setTranslateX(300);
        ghostBottom.setTranslateY(positionGhostMiddle);
        ghostMiddle.setTranslateX(positionGhostBot);
        ghostMiddle.setTranslateY(positionGhostBot);
        ghostLeft.setTranslateY(-300);
        ghostLeft.setTranslateX(positionGhostMiddle);
        ghostBotLeft.setTranslateX(positionGhostMiddle);
        ghostBotLeft.setTranslateY(positionGhostBot);

        //Draw ghost
        root.getChildren().addAll(ghostBottom, ghostMiddle, ghostUp, ghostLeft,ghostBotLeft);
        setRoot(root);

        //Move Ghost
        positionGhostUp += 2;
        positionGhostMiddle += 2;
        positionGhostBot -= 2;

        //Change scene and stop music
        if(positionGhostUp == 0){
            gameOverMusic.stopMusic();
            Labygame.setScene(Labygame.MENU_SCENE);
        }
    }
}
