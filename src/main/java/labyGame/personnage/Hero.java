package labyGame.personnage;

import labyGame.items.Item;
import labyGame.items.ItemName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

public class Hero extends Role implements Serializable {
    private HashMap<Item,Integer> myItem;

    //All args constructor
    public Hero(int hp, CharacterState status, String name, int power, int positionX, int positionY, HashMap<Item, Integer> myItem) {
        super(hp,name, power, status);
        this.myItem = myItem;
        super.positionX = positionX;
        super.positionY = positionY;
    }

    @Override
    public void basicAttack(Role target) {
        Random rand = new Random();
        target.setHp(-rand.nextInt(power - power/2+2) + power/2+2);
    }

    @Override
    public String toString() {
        return String.format("My name is %s, I'm the hero who will defeat this labyrinth !", name);
    }

    @Override
    public String basicTalk(String sentence) {
        return sentence.substring(0,1).toUpperCase() + toString().substring(1);
    }

    @Override
    public void secretAttack(Role target) {
        Random rand = new Random();
        if (CharacterState.NORMAL == currentStatus)
            target.setHp(-rand.nextInt(power*power - power*10) + power *10);
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
        if (itemTargeted.name() == ItemName.ANTIDOTE)
            currentStatus = CharacterState.NORMAL;
        else
            hp += itemTargeted.bonus();
        myItem.put(itemTargeted, myItem.get(itemTargeted) - 1);
    }

    //get and set method

    public HashMap<Item, Integer> getMyItem() {
        return myItem;
    }

    public void setMyItem(HashMap<Item, Integer> myItem) {
        this.myItem = myItem;
    }

}

