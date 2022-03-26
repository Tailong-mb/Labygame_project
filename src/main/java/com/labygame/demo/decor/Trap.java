package com.labygame.demo.trayEnvironnement.Decor;

import com.labygame.demo.personnage.Hero;
import javafx.scene.image.Image;

public class Trap implements DecorInterface {

    int hp;
    String name;
    private final transient Image myImage = new Image("file:doc/images/");
    private int positionX;
    private int positionY;

    public Trap(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public void hurtHero(Hero hero) {
        hero.setHp(-5);
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }
}
