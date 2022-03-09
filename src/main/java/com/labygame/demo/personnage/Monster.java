package com.labygame.demo.personnage;

import java.util.Random;

public class Monster extends Role {
    //All args constructor
    public Monster(int hp, CharacterState status, String name, int power, int positionX, int positionY){
        super(hp,name, power, status);
        super.positionX = positionX;
        super.positionY = positionY;
    }

    //Basic status
    public Monster(int hp, String name, int power, int positionX, int positionY){
        super(hp,name,power);
        super.positionX = positionX;
        super.positionY = positionY;
    }

    @Override
    public String basicTalk(String sentence) {
        return sentence.replaceAll("[aeiou]", "");
    }

    @Override
    public void secretAttack(Role target) {
        Random rand = new Random();
        if (CharacterState.NORMAL == currentStatus)
            target.setHp(target.getHp() - rand.nextInt(power*10) - power*10);
    }

    @Override
    public void basicAttack(Role target) {
        Random rand = new Random();
        target.setHp(target.getHp() - rand.nextInt(power*2) - power/2);
    }

}
