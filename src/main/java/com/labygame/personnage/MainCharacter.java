package com.labygame.personnage;

import javafx.scene.image.Image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Classe à supprimer à la fin

public class MainCharacter extends Sprites {
    //Attributes
    public static final int CHARAC_WIDTH = 16;
    public static final int CHARAC_HEIGHT = 30;
    private static final String PATH = "file:doc/images/gfx/gfx/character.png";
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    public MainCharacter() {
        super(CHARAC_WIDTH, CHARAC_HEIGHT);
        try{
            spriteImage = new Image(Files.newInputStream(Paths.get(PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        spriteX = 0;
        spriteY = 0;
    }

    public void move(int move){
        int newX = x;
        int newY = y;
        if(move == LEFT){
            newX -= 1;
        }
        else if(move == RIGHT){
            newX += 1;
        }
        else if(move == UP){
            newY -= 1;
        }
        else if(move == DOWN){
            newY += 1;
        }
        moveTo(newX,newY);
    }
}
