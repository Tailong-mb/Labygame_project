package labyGame.personnage;

public class Monster extends Role {
    //All args constructor
    public Monster(int hp, CharacterState status, String name, int power, int positionX, int positionY){
        super(hp,name, power, status);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    //Basic status
    public Monster(int hp, String name, int power, int positionX, int positionY){
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
