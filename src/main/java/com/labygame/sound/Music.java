package com.labygame.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class Music {

    Media media;
    MediaPlayer mp;

    public Music() {
        this.media = new Media(Paths.get(("doc/Music/GamerInstincts.mp3")).toUri().toString());
        this.mp = new MediaPlayer(media);

    }

    public void playMusic() {


        mp.play();

    }

    public void stopMusic() {

        mp.stop();

    }

}
