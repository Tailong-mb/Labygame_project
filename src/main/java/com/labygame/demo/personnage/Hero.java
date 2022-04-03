package com.labygame.demo.personnage;

import com.labygame.demo.Sprites;
import com.labygame.demo.items.Item;
import com.labygame.demo.items.ItemName;
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
    private transient HashMap<Item,Integer> myItem;
    private final transient Image myImage = new Image("file:doc/images/gfx/gfx/character.png");
    private Sprites mainCharacter;

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    private boolean stuckR = false;
    private boolean stuckL = false;
    private boolean stuckU = false;
    private boolean stuckD = false;

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
     * this method check if hero is hitting an object
     * @param check array that contains 4 int, position in X, position in Y, width and height of an object
     * @return true if there is a collision and false other way
     */
    public boolean collision( Integer[] check){
        if((getPositionX() + mainCharacter.getWidth()*2 <= check[0]) || (getPositionX() >= check[0]+check[2])) {
            return false;
        }
        if((getPositionY() + mainCharacter.getHeight()*2 <= check[1]) || (getPositionY() >= check[1]+check[3])) {
            return false;
        }
        return true;
    }
}
