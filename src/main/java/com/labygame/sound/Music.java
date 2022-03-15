package com.labygame.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Music {

    Media media;
    MediaPlayer mp;

    public Music() {
        this.media = new Media(Paths.get(("doc/Music/GamerInstincts.mp3")).toUri().toString());
        this.mp = new MediaPlayer(media);

    }

    public void playMusic() {

        int count = INDEFINITE;
        mp.setVolume(0.5f);
        mp.setCycleCount(count);
        mp.play();

    }

    public void stopMusic() {

        mp.stop();

    }

    public void playGameOverMusic() {

        this.media = new Media(Paths.get("doc/Music/ItsNotGameOverYet.mp3").toUri().toString());
        this.mp = new MediaPlayer(media);

        mp.play();

    }

    public void playBattleMusic() {

        this.media = new Media(Paths.get("doc/Music/WeMustBattleNOW.mp3").toUri().toString());
        this.mp = new MediaPlayer(media);

        mp.play();

    }

}
