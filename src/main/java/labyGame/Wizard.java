package labyGame;

public class Wizard extends Role {

    //All args constructor
    public Wizard(int hp, CharacterState status, String name, int power){
        super(hp,name, power, status);
    }

    //Basic status
    public Wizard(int hp, String name, int power){
        super(hp,name,power);
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
