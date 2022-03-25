package com.labygame.decor;

import com.labygame.personnage.Hero;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Trap implements DecorInterface {

    int hp = 15;
    int hp = 30;

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }

    @Override
    public boolean isVisible() {
        if(setVisible() == true)
            return true;
        else
            return false;
    }

    public boolean setVisible(boolean yn) {
        return yn;
    }

    @Override
    public void hurtHero(Hero hero) {
        hero.setHp(-5);
        this.hp -= -5;
        if(isVisible() == true){
            hero.setHp(-10);
            this.hp -= 10;
        }
    }
}
