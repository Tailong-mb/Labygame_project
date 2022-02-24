package labyGame.trayEnvironnement.Decor;

import labyGame.personnage.Hero;

public interface DecorInterface {

    /**
     * Check if the decor is destroyed or not.
     */
    boolean isDestroyed();

    /**
     * Some decor canMove with some conditions.
     * @return true if it's possible otherwise false.
     */
    boolean canMove();

    /**
     * Some decor item can hurt the hero.
     * @param hero the main character.
     */
    void hurtHero(Hero hero);

}
