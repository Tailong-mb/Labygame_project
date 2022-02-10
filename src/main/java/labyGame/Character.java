package labyGame;

import java.util.Objects;

public abstract class Character {
    protected int hp;
    protected characterState currentStatus;
    protected String name;
    protected int power;


    //All args constructor
    public Character(int Hp, String name, int power, characterState currentStatus){
        this.hp = Hp;
        this.currentStatus = currentStatus;
        this.name = name;
        this.power = power;
    }

    //Basic constructor
    public Character(int Hp, String name, int power){
        this.hp = Hp;
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
     * Check is the character is dead or not.
     * @return yes if Hp are under or equal to 0 otherwise false;
     */
    public boolean isDead(){
        return this.hp <= 0;
    }

    /**
     * Principal method for a character to attack
     * @param target of the attack
     */
    public abstract void basicAttack(Character target);

    /**
     * Secret attack method (should have a cool down)
     * @param target of the secret attack
     */
    public abstract void secretAttack(Character target);

    /**
     * Charter will talk with some specificities
     * @param sentence that will be changed
     * @return the same sentence after change.
     */
    public abstract String basicTalk(String sentence);

    //Method toString, the character will present himself.
    @Override
    public abstract String toString();

    //Getter and Setter method
    public int getHp() {
        return hp;
    }

    public characterState getCurrentStatus() {
        return currentStatus;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public void setCurrentStatus(characterState currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character character)) return false;
        return getPower() == character.getPower() && getName().equals(character.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPower());
    }
}
