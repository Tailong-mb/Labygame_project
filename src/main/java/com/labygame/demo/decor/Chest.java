package com.labygame.demo.decor;

import com.labygame.demo.personnage.Hero;
import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chest implements DecorInterface{
    private final transient Image myImage = new Image("file:doc/images/element/chest.png");
    private boolean visible;
    private final int positionX = 250;
    private final int positionY = 150;
    private final int WIDTH = 30;
    private final int HEIGHT = 32;

    private boolean opened = false;

    @Override
    public boolean isDestroyed() {
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
