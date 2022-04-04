package com.labygame.front;

import javafx.scene.canvas.GraphicsContext;
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

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(GraphicsContext gc){
        gc.drawImage(spriteImage,spriteX,spriteY,width,height,x,y,width,height);
    }
}
