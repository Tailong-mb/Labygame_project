package com.labygame.personnage;

import lombok.Getter;

@Getter
public enum CharacterState {
    NORMAL("NORMAL"),
    SICK("SICK"),
    WEARY("WEARY"),
    POISON("POISON");

    private final String nameState;

    CharacterState(String nameState){
        this.nameState = nameState;
    }

}