package com.labygame.decor;

import com.labygame.personnage.Hero;
import javafx.scene.image.Image;
import lombok.Getter;

@Getter
public class Hedges implements DecorInterface{
    private final transient Image myImage = new Image("file:doc/images/nature/plant_hedges.png");
    private final int spriteXHorizontal = 10;
    private final int spriteYHorizontal = 10;
    private final int spriteXVertical = 14;
    private final int spriteYVertical = 80;
    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean changeVisible() {
        return true;
    }

    @Override
    public void hurtHero(Hero hero) {

    }
}
