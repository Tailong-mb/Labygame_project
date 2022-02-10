package labyGame;

public class Wizard extends Character {

    //All args constructor
    public Wizard(int Hp, characterState status,String Name,int Power){
        super(Hp,Name, Power, status);
    }

    //Basic status
    public Wizard(int Hp, String name, int power){
        super(Hp,name,power);
    }

    @Override
    public void basicAttack(Character target) {
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
    public void secretAttack(Character target) {
        //a remplir
    }
}
