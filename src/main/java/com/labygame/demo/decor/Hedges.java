package com.labygame.demo.decor;

import com.labygame.demo.personnage.Hero;
import javafx.scene.image.Image;

public class Hedges implements DecorInterface{
    private final transient Image myImage = new Image("file:doc/images/plant_hedges.png");
    private final int WIDTH = 30;
    private final int HEIGHT = 25;
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
