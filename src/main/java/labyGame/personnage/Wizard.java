package labyGame.personnage;

import labyGame.personnage.CharacterState;
import labyGame.personnage.Role;

public class Wizard extends Role {

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
}
