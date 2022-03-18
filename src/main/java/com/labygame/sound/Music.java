package com.labygame.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import lombok.Getter;

import java.nio.file.Paths;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

@Getter
public class Music {

    MediaPlayer musicPlayer;
    MusicType musicType;


    //constructor
    public Music(MusicType musicType) {

        this.musicPlayer = new MediaPlayer(new Media(Paths.get((musicType.getPathMusic())).toUri().toString()));
    }

    /**
     * method to play main music of the game
     */
    public void playMusic() {

        this.musicPlayer.setVolume(0.5f);
        this.musicPlayer.setCycleCount(INDEFINITE);
        this.musicPlayer.play();
    }

    /**
     * method to stop playing music
     */
    public void stopMusic() {
        this.musicPlayer.stop();
    }
}