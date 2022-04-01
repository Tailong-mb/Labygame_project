package com.labygame.demo.decor;

import com.labygame.demo.personnage.Hero;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Trap implements DecorInterface {
    private static int hp = 30;
    private boolean isVisible = false;
    private final int positionX = 600;
    private final int positionY = 450;
    private final int widthSprite = 30;
    private final int heightSprite = 32;

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }

    public boolean changeVisible() {
        if(isVisible == true)
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
        if(this.changeVisible() == true){
            hero.setHp(-10);
            this.hp -= 10;
        }
    }
}