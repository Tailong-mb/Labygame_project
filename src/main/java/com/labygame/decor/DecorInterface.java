package com.labygame.decor;

import com.labygame.personnage.Hero;

public interface DecorInterface {

    /**
     * Check if the decor is destroyed or not.
     */
    boolean isDestroyed();

    /**
     * Some decor are visible or not with some conditions.
     * @return true if it's possible otherwise false.
     */
    boolean isVisible();

    /**
     * Some decor item can hurt the hero.
     * @param hero the main character.
     */
    void hurtHero(Hero hero);

}
