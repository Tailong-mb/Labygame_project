package com.labygame.decor;


import com.labygame.personnage.Hero;

public class Tree implements DecorInterface {

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
}
