package labyGame.trayEnvironnement.Decor;

import labyGame.personnage.Hero;

public class Trap implements DecorInterface {

    int hp;
    String name;

    public Trap(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    @Override
    public boolean isDestroyed() {
        if(hp <= 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public void hurtHero(Hero hero) {
        hero.setHp(-5);
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }
}
