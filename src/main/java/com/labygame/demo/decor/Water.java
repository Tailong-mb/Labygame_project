package com.labygame.demo.trayEnvironnement.Decor;

import com.labygame.demo.personnage.Hero;
import javafx.scene.image.Image;
import lombok.Getter;

@Getter
public class Water implements DecorInterface {

    private final transient Image myImage = new Image("file:doc/images/water2.png");
    private int positionX;
    private int positionY;

    public Water(int x, int y) {
        positionX = x;
        positionY = y;
    }

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
