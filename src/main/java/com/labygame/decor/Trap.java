package com.labygame.decor;

import com.labygame.personnage.Hero;
import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Trap implements DecorInterface {

    int hp;
    String name;
    Image image;

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

    @Override
    public void setImage(){
        this.image = new Image("doc/images/tree (1).png");
    }
}
