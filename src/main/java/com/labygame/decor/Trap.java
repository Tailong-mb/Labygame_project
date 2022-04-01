package com.labygame.decor;

import com.labygame.personnage.Hero;
import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Trap implements DecorInterface {

    int hpTrap = 30;
    int i = 300;
    boolean b;

    Image image;

    @Override
    public boolean isDestroyed() {
        return hpTrap <= 0;
    }

    @Override
    public boolean isVisible() {
        if (setVisible())
            return true;
        else
            return false;
    }

    public boolean setVisible() {
        for(;;) {
            b = true;
            while(i!=0){
                b = false;
                i--;
            }
            return b;
        }
    }

    @Override
    public void hurtHero(Hero hero) {
        hero.setHp(-5);
        this.hpTrap -= -5;
        if(isVisible()){
            hero.setHp(-10);
            this.hpTrap -= 10;
        }
    }

    @Override
    public void setImage() {
        if(isVisible())
            this.image = new Image("doc/images/trap.png");
    }

}
