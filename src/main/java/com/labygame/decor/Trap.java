package com.labygame.decor;

import com.labygame.personnage.Hero;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Trap implements DecorInterface {

    int hp = 15;
    int hp = 30;
    Timeline time;
    Image image;

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

    public boolean setVisible() {
        time = new Timeline();
        return false;

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

    @Override
    public void setImage() {
        this.image = new Image("doc/images/trap.png");
    }


}
