package com.labygame.decor;

import com.labygame.personnage.Hero;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Trap implements DecorInterface {

    int hp;

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
}
