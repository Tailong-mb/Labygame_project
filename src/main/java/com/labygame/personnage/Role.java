package com.labygame.personnage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Role {
    @JsonProperty("hp")
    protected int hp;
    @JsonProperty("currentStatus")
    protected CharacterState currentStatus;
    @JsonProperty("name")
    protected String name;
    @JsonProperty("power")
    protected int power;
    @JsonProperty("positionX")
    protected int positionX;
    @JsonProperty("positionY")
    protected int positionY;

    public Role(int hp, String name, int power, CharacterState status) {
        this.hp = hp;
        this.name = name;
        this.power = power;
        this.currentStatus = status;
    }

    /**
     * The Character yell.
     *
     * @param sentence that will be yelled
     * @return the same sentence with upper case character.
     */
    public String yell(String sentence) {
        return sentence.toUpperCase();
    }

    /**
     * Check is the character is dead or not.
     *
     * @return yes if hp are under or equal to 0 otherwise false;
     */
    public boolean isDead() {
        return hp <= 0;
    }

    /**
     * Principal method for a character to attack
     *
     * @param target of the attack
     */
    public abstract void basicAttack(Role target);

    /**
     * Secret attack method (should have a cool down)
     *
     * @param target of the secret attack
     */
    public abstract void secretAttack(Role target);

    /**
     * Charter will talk with some specificities
     *
     * @param sentence that will be changed
     * @return the same sentence after change.
     */
    public abstract String basicTalk(String sentence);
}