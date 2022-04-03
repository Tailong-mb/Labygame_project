package com.labygame.sound;

import lombok.Getter;

@Getter
public enum MusicType {
    MENU("doc/Music/GamerInstincts.mp3"),
    END("doc/Music/ItsNotGameOverYet.mp3"),
    FIGHT("doc/Music/WeMustBattleNOW.mp3"),
    BASIC("doc/Music/GamerInstincts.mp3");

    private final String pathMusic;

    MusicType(String pathMusic){
        this.pathMusic = pathMusic;
    }
}
