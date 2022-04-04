package com.labygame.demo.decor;

import com.labygame.demo.personnage.Hero;
import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Trap implements DecorInterface {
    private final transient Image myImage = new Image("file:doc/images/element/trap.png");
    private static int hp = 30;
    private boolean visible = false;
    private final int positionX = 600;
    private final int positionY = 450;
    private final int WIDTH = 23;
    private final int HEIGHT = 32;

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }

    public boolean changeVisible() {
        if(visible == true)
            return true;
        else
            return false;
    }

    public void setVisible(boolean yn) {
        this.visible = yn;
    }

    @Override
    public void hurtHero(Hero hero) {
        if(!visible) {
            hero.setHp(-5);
            this.hp -= -5;
            if (this.changeVisible() == true) {
                hero.setHp(-10);
                this.hp -= 10;
            }
        }
    }
}