package com.labygame.front;

import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sprites {
    protected int width, height;
    protected int x, y;
    protected int spriteX, spriteY;
    protected Image spriteImage;

    public Sprites(int width, int height){
        this.width = width;
        this.height = height;
    }

}
