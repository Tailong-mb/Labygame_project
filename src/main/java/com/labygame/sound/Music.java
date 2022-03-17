package com.labygame.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Music {

    MediaPlayer mp;

    //constructor
    public Music() {

        this.mp = new MediaPlayer(new Media(Paths.get(("doc/Music/GamerInstincts.mp3")).toUri().toString()));

    }

    /**
     * method to play main music of the game
     */
    public void playMusic() {

        int count = INDEFINITE;
        this.mp.setVolume(0.5f);
        this.mp.setCycleCount(count);
        this.mp.play();

    }

    /**
     * method to stop playing music
     */
    public void stopMusic() {

        this.mp.stop();

    }

    /**
     * method to play music for the GameOver scene
     */
    public void playGameOverMusic() {

        this.mp = new MediaPlayer(new Media(Paths.get("doc/Music/ItsNotGameOverYet.mp3").toUri().toString()));
        this.mp.setVolume(0.5f);
        this.mp.play();

    }

    /**
     * method to play music for the Fight scene
     */
    public void playBattleMusic() {

        this.mp = new MediaPlayer(new Media(Paths.get("doc/Music/WeMustBattleNOW.mp3").toUri().toString()));
        this.mp.setVolume(0.5f);
        this.mp.play();

    }

    /**
     * method to get the music which  was playing
     * @return mp
     */
    public MediaPlayer getMusic() {
        return this.mp;
    }
}
