import org.junit.jupiter.api.Test;
import labyGame.personnage.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestMonster {

    @Test
    void toStringMonster(){
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        assertEquals("My name is Demon, I'm one of the labyrinth's guardians !",myMonster.toString());
    }

    @Test
    void basicTalkMonster(){
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        assertEquals("I will defeat you",myMonster.basicTalk("i wiLl DefeAt yoU"));
    }

    @Test
    void secretAttackMonsterBadStatus(){
        Monster myMonster = new Monster(50, CharacterState.WEARY,"Demon",10,0,0);
        Monster mySecondMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        myMonster.secretAttack(mySecondMonster);
        assertEquals(50,mySecondMonster.getHp());
    }

    @Test
    void secretAttackMonsterGoodStatusShouldKIll(){
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        Monster mySecondMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        myMonster.secretAttack(mySecondMonster);
        assertTrue(mySecondMonster.isDead());
    }

    @Test
    void basicAttackMonsterShouldNotKIll(){
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        Monster mySecondMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        myMonster.basicAttack(mySecondMonster);
        assertFalse(mySecondMonster.isDead());
    }

    @Test
    void basicAttackMonsterShouldKIll(){
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        Monster mySecondMonster = new Monster(10, CharacterState.NORMAL,"Demon",10,0,0);
        myMonster.basicAttack(mySecondMonster);
        assertTrue(mySecondMonster.isDead());
    }
}
