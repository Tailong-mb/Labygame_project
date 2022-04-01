package com.labygame.decor;


import com.labygame.personnage.Hero;
import javafx.scene.image.Image;

public class Tree implements DecorInterface {

    Image image;

    @Override
    public boolean isDestroyed(){
        return false;
    }

    @Override
    public boolean isvisible() {
        return true;
    }

    @Override
    public void hurtHero(Hero hero) {
        hero.setHp(0);
    }

    @Override
    public void setImage(){
        this.image = new Image("doc/images/tree (1).png");
    }
}
