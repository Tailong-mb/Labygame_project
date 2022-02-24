package labyGame.trayEnvironnement.Decor;


import labyGame.personnage.Hero;

public class Water implements DecorInterface {

    public boolean isDestroyed(){
        return false;
    }

    public boolean canMove() {
        return false;
    }

    public void hurtHero(Hero hero) {
        hero.setHp(0);
    }
}
