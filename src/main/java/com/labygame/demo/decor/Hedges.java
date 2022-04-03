package com.labygame.demo.decor;

import com.labygame.demo.personnage.Hero;
import javafx.scene.image.Image;

public class Hedges implements DecorInterface{
    private final transient Image myImage = new Image("file:doc/images/tree (1).png");
    private final int WIDTH = 44;
    private final int HEIGHT = 47;
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
