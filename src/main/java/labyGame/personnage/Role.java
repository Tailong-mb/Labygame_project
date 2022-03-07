package labyGame.personnage;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Role {
    protected int hp;
    protected transient CharacterState currentStatus;
    protected String name;
    protected int power;
    protected int positionX;
    protected int positionY;

    //Basic constructor
    public Role(int hp, String name, int power) {
        this.hp = hp;
        this.currentStatus = CharacterState.NORMAL;
        this.name = name;
        this.power = power;
    }

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