package com.labygame.sound;

import lombok.Getter;

@Getter
public enum MusicType {
    MENU("doc/Music/menu-theme.mp3"),
    END("doc/Music/ItsNotGameOverYet.mp3"),
    FIGHT("doc/Music/fight-theme.mp3"),
    BASIC("doc/Music/basic-theme.mp3"),
    CREDIT("doc/Music/credit-theme.wav");

    private final String pathMusic;

    MusicType(String pathMusic){
        this.pathMusic = pathMusic;
    }
}
