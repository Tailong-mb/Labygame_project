package labyGame;

import java.util.Locale;

public abstract class Character {
    protected int Hp;
    protected characterState currentStatus;
    protected String name;
    protected int power;


    //All args constructor
    public Character(int Hp, String name, int power, characterState currentStatus){
        this.Hp = Hp;
        this.currentStatus = currentStatus;
        this.name = name;
        this.power = power;
    }

    //Basic constructor
    public Character(int Hp, String name, int power){
        this.Hp = Hp;
        this.currentStatus = characterState.NORMAL;
        this.name = name;
        this.power = power;
    }

    /**
     * The Character yell.
     * @param sentence that will be yelled
     * @return the same sentence with upper case character.
     */
    public String yell(String sentence){
        return sentence.toUpperCase();
    }

    /**
     * Principal method for a character to attack
     * @param target of the attack
     */
    public abstract void basicAttack(Character target);

    /**
     * Secret attack method (should have a cooldown)
     * @param target of the secret attack
     */
    public abstract void secretAttack(Character target);

    //Method toString, the character will present himself.
    public abstract String toString();
}
