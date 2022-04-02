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
    public boolean canMove() {
        return false;
    }

    @Override
    public void hurtHero(Hero hero) {
        hero.setHp(0);
    }

    public void setImage(){
        this.image = new Image("doc/images/tree (1).png");
    }

}
