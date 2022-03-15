package com.labygame.personnage;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum CharacterState implements Serializable {
    NORMAL("NORMAL"),
    SICK("SICK"),
    WEARY("WEARY"),
    POISON("POISON");

    private final String nameState;

    CharacterState(String nameState){
        this.nameState = nameState;
    }

}
