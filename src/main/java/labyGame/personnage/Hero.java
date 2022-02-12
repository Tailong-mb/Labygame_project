package labyGame.personnage;

import labyGame.items.Item;

import java.util.HashMap;

public class Hero extends Role {
    private HashMap<Item,Integer> myItem;
    private int positionX;
    private int positionY;

    //All args constructor
    public Hero(int hp, CharacterState status, String name, int power, int positionX, int positionY, HashMap<Item, Integer> myItem) {
        super(hp,name, power, status);
        this.myItem = myItem;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public void basicAttack(Role target) {
        //A remplir
    }

    @Override
    public String toString() {
        //A remplir
        return null;
    }

    @Override
    public String basicTalk(String sentence) {
        //a remplir
        return null;
    }

    @Override
    public void secretAttack(Role target) {
        //a remplir
    }

    //get and set method

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public HashMap<Item, Integer> getMyItem() {
        return myItem;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setMyItem(HashMap<Item, Integer> myItem) {
        this.myItem = myItem;
    }

}
