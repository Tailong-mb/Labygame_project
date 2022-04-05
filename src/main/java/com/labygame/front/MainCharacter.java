package com.labygame.front;

import javafx.scene.image.Image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainCharacter extends Sprites {
    //Attributes
    public static final int CHARAC_WIDTH = 16;
    public static final int CHARAC_HEIGHT = 30;
    private static final String PATH = "file:doc/images/gfx/gfx/character.png";

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

}
