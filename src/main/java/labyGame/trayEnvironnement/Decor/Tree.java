package labyGame.trayEnvironnement.Decor;

import labyGame.personnage.Hero;

public class Tree implements DecorInterface {

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
