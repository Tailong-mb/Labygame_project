package com.labygame.demo.decor;

import com.labygame.demo.personnage.Hero;
import javafx.scene.image.Image;
import lombok.Getter;

@Getter
public class Water implements DecorInterface {

    private final transient Image myImage = new Image("file:doc/images/nature/water2.png");
    private int positionX;
    private int positionY;
    private final int WIDTH = 30;
    private final int HEIGHT = 30;

    public Water(int x, int y) {
        positionX = x;
        positionY = y;
    }

    @Override
    public boolean isDestroyed(){
        return false;
    }

    @Override
    public boolean changeVisible() {
        return true;
    }

    @Override
    public void hurtHero(Hero hero) {
        hero.setHp(0);
    }
}
