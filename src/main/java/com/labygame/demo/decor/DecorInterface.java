
package com.labygame.demo.decor;

import com.labygame.demo.personnage.Hero;

public interface DecorInterface {

    /**
     * Check if the decor is destroyed or not.
     */
    boolean isDestroyed();

    /**
     * Some decor are visible or not with some conditions.
     * @return true if it's possible otherwise false.
     */
    boolean changeVisible();

    /**
     * Some decor item can hurt the hero.
     * @param hero the main character.
     */
    void hurtHero(Hero hero);

}