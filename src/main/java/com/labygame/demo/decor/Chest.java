package com.labygame.demo.decor;

import com.labygame.demo.personnage.Hero;
import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chest implements DecorInterface{
    private final transient Image myImage = new Image("file:doc/images/chest.png");
    private final int positionX = 400;
    private final int positionY = 350;
    private final int widthSprite = 30;
    private final int heightSprite = 32;

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
