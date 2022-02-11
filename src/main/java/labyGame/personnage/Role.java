package labyGame.personnage;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public abstract class Role {
    protected int hp;
    protected CharacterState currentStatus;
    protected String name;
    protected int power;


    //All args constructor
    public Role(int hp, String name, int power, CharacterState currentStatus){
        this.hp = hp;
        this.currentStatus = currentStatus;
        this.name = name;
        this.power = power;
    }

    //Basic constructor
    public Role(int hp, String name, int power){
        this.hp = hp;
        this.currentStatus = CharacterState.NORMAL;
        this.name = name;
        this.power = power;
    }

    /**
     * The Character yell.
     * @param sentence that will be yelled
     * @return the same sentence with upper case character.
     */
    public String yell(@NotNull String sentence){
        return sentence.toUpperCase();
    }

    /**
     * Check is the character is dead or not.
     * @return yes if hp are under or equal to 0 otherwise false;
     */
    public boolean isDead(){
        return hp <= 0;
    }

    /**
     * Principal method for a character to attack
     * @param target of the attack
     */
    public abstract void basicAttack(Role target);

    /**
     * Secret attack method (should have a cool down)
     * @param target of the secret attack
     */
    public abstract void secretAttack(Role target);

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

    public CharacterState getCurrentStatus() {
        return currentStatus;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public void setCurrentStatus(CharacterState currentStatus) {
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
        if (!(o instanceof Role role)) return false;
        return getPower() == role.getPower() && getName().equals(role.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPower());
    }
}
