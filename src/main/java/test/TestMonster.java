package test;

import com.labygame.demo.personnage.CharacterState;
import com.labygame.demo.personnage.Monster;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMonster {

    @Test
    void basicTalkMonster(){
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        assertEquals("I wll dft y",myMonster.basicTalk("I will defeat you"));
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
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",20,0,0);
        Monster mySecondMonster = new Monster(10, CharacterState.NORMAL,"Demon",10,0,0);
        myMonster.basicAttack(mySecondMonster);
        assertTrue(mySecondMonster.isDead());
    }
}
