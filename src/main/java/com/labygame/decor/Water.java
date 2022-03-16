package com.labygame.decor;

import com.labygame.personnage.Hero;

public class Water implements DecorInterface {

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
}
