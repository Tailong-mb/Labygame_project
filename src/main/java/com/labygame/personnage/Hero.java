package com.labygame.personnage;

import com.labygame.items.Item;
import com.labygame.items.ItemName;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
public class Hero extends Role implements Serializable {
    private transient HashMap<Item,Integer> myItem;

    //All args constructor
    public Hero(int hp, CharacterState status, String name, int power, int positionX, int positionY, HashMap<Item, Integer> myItem) {
        super(hp,name, power, status);
        this.myItem = myItem;
        super.positionX = positionX;
        super.positionY = positionY;
    }

    //Constructor without Item
    public Hero(int hp, CharacterState status, String name, int power, int positionX, int positionY) {
        super(hp,name, power, status);
        super.positionX = positionX;
        super.positionY = positionY;
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
        if (CharacterState.NORMAL == currentStatus) {
            target.setHp(target.getHp() - rand.nextInt(power * power - power * 9) - power * 10);
            currentStatus = CharacterState.WEARY;
        }
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
            if (((itemTargeted.name() == ItemName.ANTIDOTE) && (currentStatus == CharacterState.POISON)) ||
                    ((itemTargeted.name() == ItemName.HEALPOTION) && (currentStatus == CharacterState.SICK)) ||
                    ((itemTargeted.name() == ItemName.ENERGYDRINK) && (currentStatus == CharacterState.WEARY))){
                currentStatus = CharacterState.NORMAL;
                power += 10;
            }
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
                power -= 3;
            }
            case WEARY -> power -= 3;
            default -> hp += 2;
        }
    }

    //get and set method

    public HashMap<Item, Integer> getMyItem() {
        return myItem;
    }

    public void setMyItem(HashMap<Item, Integer> myItem) {
        this.myItem = myItem;
    }
}

