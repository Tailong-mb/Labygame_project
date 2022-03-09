package labyGame.trayEnvironnement.Decor;

import javafx.scene.image.Image;
import labyGame.personnage.Hero;

public class Tree implements DecorInterface {

    Image image;

    @Override
    public boolean isDestroyed() {
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

    @Override
    public void setImage(){
        this.image = new Image("doc/images/tree.png");
    }
}