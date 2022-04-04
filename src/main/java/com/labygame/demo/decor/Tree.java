package com.labygame.demo.decor;

import com.labygame.demo.personnage.Hero;
import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tree implements DecorInterface {
    private final transient Image myImage = new Image("file:doc/images/nature/tree (1).png");
    private int positionX;
    private int positionY;
    private final int WIDTH = 44;
    private final int HEIGHT = 47;

    public Tree(int x, int y) {
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
