package com.labygame.demo.personnage;

import com.labygame.demo.riddles.Riddles;
import javafx.scene.image.Image;
import lombok.Getter;

import java.util.Random;

@Getter
public class Wizard extends Role {

    private final transient Image myImage = new Image("file:doc/images/gfx/gfx/mage.png");
    private Riddles currentRiddle;

    //All args constructor
    public Wizard(int hp, CharacterState status, String name, int power, int positionX, int positionY){
        super(hp,name, power, status);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    //Basic status
    public Wizard(int hp, String name, int power, int positionX, int positionY){
        super(hp,name,power);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public String basicTalk(String sentence) {
        return sentence.substring(0,1).toUpperCase() + sentence.substring(1) + " ahah !";
    }

    @Override
    public void secretAttack(Role target) {
        Random rand = new Random();
        if (CharacterState.NORMAL == currentStatus)
            target.setHp(target.getHp()-rand.nextInt(power*power - power*2) - power *15);
    }

    @Override
    public void basicAttack(Role target) {
        Random rand = new Random();
        target.setHp(target.getHp()-rand.nextInt(power - power/4) - power/2+3);
    }
    /**
     * Method for ask riddle
     * @return a riddle
     */
    public String askQuestion() {
        Random rand = new Random();
        currentRiddle = Riddles.values()[rand.nextInt(12)];
        return currentRiddle.getRid();
    }

    /**
     * Check if the answer is correct
     * @param answer the answer
     * @return true if it's right else false.
     */
    public boolean ansVerification(String answer) {

        return answer.toLowerCase().matches(String.format(("(.*)%s(.*)"),currentRiddle.getAns().toLowerCase()));

    }

    //GetRiddle
    public Riddles getCurrentRiddle() {
        return currentRiddle;
    }

}
