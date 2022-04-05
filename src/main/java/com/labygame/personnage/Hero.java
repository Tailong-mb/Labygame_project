package com.labygame.personnage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.labygame.items.Item;
import com.labygame.items.ItemName;
import javafx.scene.image.Image;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Hero extends Role implements Serializable {
    private boolean haveMagicKey = false;
    private HashMap<Item,Integer> myItem;

    @JsonIgnore
    private final transient Image myImage = new Image("file:doc/images/gfx/gfx/character.png");
    @JsonIgnore
    private transient Sprites mainCharacter;
    @JsonIgnore
    public transient static final int LEFT = 0;
    @JsonIgnore
    public transient static final int RIGHT = 1;
    @JsonIgnore
    public transient static final int UP = 2;
    @JsonIgnore
    public transient static final int DOWN = 3;

    private transient boolean stuckR = false;
    private transient boolean stuckL = false;
    private transient boolean stuckU = false;
    private transient boolean stuckD = false;

    //All args constructor
    public Hero(int hp, CharacterState status, String name, int power, int positionX, int positionY, HashMap<Item, Integer> myItem) {
        super(hp,name, power, status);
        this.myItem = myItem;
        super.positionX = positionX;
        super.positionY = positionY;
        mainCharacter = new Sprites(16,24);
        mainCharacter.setSpriteImage(new Image("file:doc/images/gfx/gfx/character.png"));
        mainCharacter.setSpriteX(0);
        mainCharacter.setSpriteY(6);
        haveMagicKey = false;
    }

    //Constructor without Item
    public Hero(int hp, CharacterState status, String name, int power, int positionX, int positionY) {
        super(hp,name, power, status);
        super.positionX = positionX;
        super.positionY = positionY;
        mainCharacter = new Sprites(15,29);
        mainCharacter.setSpriteImage(new Image("file:doc/images/gfx/gfx/character.png"));
        mainCharacter.setSpriteX(0);
    }

    @Override
    public String basicTalk(String sentence) {
        return sentence.substring(0,1).toUpperCase() + sentence.substring(1).toLowerCase();
    }

    @Override
    public void basicAttack(Role target) {
        Random rand = new Random();
        target.setHp(target.getHp() - rand.nextInt(power) - power/2);
    }

    @Override
    public void secretAttack(Role target) {
        Random rand = new Random();
        if (CharacterState.NORMAL == currentStatus)
            target.setHp(target.getHp() - rand.nextInt(power*power - power*9) - power *10);
        else
            hp -= power; //He hurts himself because he can't use his secret attack (not the good statement).
    }

    /**
     * Check if the item can be used.
     * @param itemTargeted the item who will be used if it's possible.
     * @return true if it's possible else false.
     */
    public boolean canUseItem(Item itemTargeted){
        return myItem.get(itemTargeted) > 0;
    }

    /**
     * When canUseItem we can use this method to use this same item.
     * @param itemTargeted the item the hero wants to use.
     */
    public void useItem(Item itemTargeted){
        if(canUseItem(itemTargeted)) {
            if (itemTargeted.name() == ItemName.ANTIDOTE)
                currentStatus = CharacterState.NORMAL;
            else
                hp += itemTargeted.bonus();
            myItem.put(itemTargeted, myItem.get(itemTargeted) - 1);
        }
    }

    /**
     * this method is for apply the effects when the currentStatus isn't NORMAL
     */
    public void stateEffect() {
        switch (currentStatus) {
            case POISON -> hp -= 10;
            case SICK -> {
                hp -= 5;
                power -= 5;
            }
            case WEARY -> power -= 3;
            default -> hp += 2;
        }
    }

    /**
     * this method allows to move the hero
     * @param move the way the hero should move
     */
    public void move(int move) {
        int newX = mainCharacter.getX();
        int newY = mainCharacter.getY();
        if (move == LEFT) {
            newX -= 10;
            setPositionX(newX);
        } else if (move == RIGHT) {
            newX += 10;
            setPositionX(newX);
        } else if (move == UP) {
            newY -= 10;
            setPositionY(newY);
        } else if (move == DOWN) {
            newY += 10;
            setPositionY(newY);
        }
        mainCharacter.moveTo(newX, newY);
    }

    /**
     * these methods check if hero is hitting an object
     * @param check array that contains 4 int, position in X, position in Y, width and height of an object
     * @return true if there is a collision and false other way
     */
    public boolean collisionX( Integer[] check){
        boolean firstCheckPosition = (getPositionX() + mainCharacter.getWidth()*3 <= check[0]) || (getPositionX() >= check[0]+check[2]);
        boolean secondCheckPosition = (getPositionY() + mainCharacter.getHeight()*3-10 <= check[1]) || (getPositionY() + 10 >= check[1]+check[3]);
        return !(firstCheckPosition || secondCheckPosition);
    }

    public boolean collisionY( Integer[] check){
        boolean firstCheckPosition = (getPositionY() + mainCharacter.getHeight()*3 <= check[1]) || (getPositionY() >= check[1]+check[3]);
        boolean secondCheckPosition = (getPositionX() + mainCharacter.getWidth()*3-10 <= check[0]) || (getPositionX() + 10 >= check[0]+check[2]);
        return !(firstCheckPosition || secondCheckPosition);
    }
}
