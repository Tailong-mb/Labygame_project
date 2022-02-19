package labyGame.personnage;

import labyGame.riddles.Riddles;
import java.util.HashMap;
import java.util.Random;

public class Wizard extends Role {

    private HashMap<Riddles, String> wizardRiddles;

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
    public void basicAttack(Role target) {
        Random rand = new Random();
        target.setHp(-rand.nextInt(power - power/4) + power/3+3);
    }

    @Override
    public String toString() {
        return String.format("My name is %s, I can help you if you answer correctly to my riddle or you can choose to fight against me.", name);
    }

    @Override
    public String basicTalk(String sentence) {
        return sentence.substring(0,1).toUpperCase() + toString().substring(1);
    }

    @Override
    public void secretAttack(Role target) {
        Random rand = new Random();
        if (CharacterState.NORMAL == currentStatus)
            target.setHp(-rand.nextInt(power*power - power*5) + power *10);
    }

    /**
     * method for ask riddle
     * @param rid the riddle ask by the wizard
     * @return a riddle
     */
    public String askQuestion(Riddles rid) {
        return wizardRiddles.get(rid);
    }
}
