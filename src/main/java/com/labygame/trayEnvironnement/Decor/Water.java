package com.labygame.trayEnvironnement.Decor;

import com.labygame.personnage.Hero;
import javafx.scene.image.Image;

public class Water implements DecorInterface {

    Image image;

    @Override
    public boolean isDestroyed(){
        return false;
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public void hurtHero(Hero hero) {
        hero.setHp(0);
    }

    @Override
    public void setImage(){
        this.image = new Image("doc/images/water.png");
    }
}