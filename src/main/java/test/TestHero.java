package test;

import com.labygame.demo.items.Item;
import com.labygame.demo.items.ItemName;
import com.labygame.demo.personnage.CharacterState;
import com.labygame.demo.personnage.Hero;
import com.labygame.demo.personnage.Monster;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TestHero {

    @Test
    void basicTalkHero(){
        Hero myHero = new Hero(50, CharacterState.NORMAL,"Jean",10,0,0);
        assertEquals("I will defeat you",myHero.basicTalk("i wiLl DefeAt yoU"));
    }

    @Test
    void secretAttackHeroBadStatus(){
        Hero myHero = new Hero(50, CharacterState.WEARY,"Jean",10,0,0);
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        myHero.secretAttack(myMonster);
        assertEquals(50,myMonster.getHp());
        assertEquals(40,myHero.getHp());
    }

    @Test
    void secretAttackHeroGoodStatusShouldKill(){
        Hero myHero = new Hero(50, CharacterState.NORMAL,"Jean",10,0,0);
        Monster myMonster = new Monster(100, CharacterState.NORMAL,"Demon",10,0,0);
        myHero.secretAttack(myMonster);
        assertTrue(myMonster.isDead());
        assertEquals(50,myHero.getHp());
    }

    @Test
    void secretAttackHeroGoodStatusShouldNotKill(){
        Hero myHero = new Hero(50, CharacterState.NORMAL,"Jean",10,0,0);
        Monster myMonster = new Monster(111, CharacterState.NORMAL,"Demon",10,0,0);
        myHero.secretAttack(myMonster);
        assertFalse(myMonster.isDead());
        assertEquals(50,myHero.getHp());
    }

    @Test
    void normalAttackHeroShouldKIll(){
        Hero myHero = new Hero(50, CharacterState.NORMAL,"Jean",10,0,0);
        Monster myMonster = new Monster(5, CharacterState.NORMAL,"Demon",10,0,0);
        myHero.basicAttack(myMonster);
        assertTrue(myMonster.isDead());
    }

    @Test
    void normalAttackHeroShouldNotKIll(){
        Hero myHero = new Hero(50, CharacterState.NORMAL,"Jean",10,0,0);
        Monster myMonster = new Monster(16, CharacterState.NORMAL,"Demon",10,0,0);
        myHero.basicAttack(myMonster);
        assertFalse(myMonster.isDead());
    }

    @Test
    void heroCanUseItem(){
        Item itemTest = new Item(2, ItemName.ANTIDOTE,"");
        Item itemTest2 = new Item(10, ItemName.HEALPOTION,"");
        HashMap<Item,Integer> itemPack = new HashMap<>() {{
            put(itemTest, 0);
            put(itemTest2, 1);
        }};
        Hero myHero = new Hero(50, CharacterState.NORMAL,"Jean",10,0,0,itemPack);
        assertFalse(myHero.canUseItem(itemTest));
        assertTrue(myHero.canUseItem(itemTest2));
    }

    @Test
    void heroUseItem(){
        Item itemTest = new Item(2,ItemName.ANTIDOTE,"");
        Item itemTest2 = new Item(10, ItemName.HEALPOTION,"");
        HashMap<Item,Integer> itemPack = new HashMap<>() {{
            put(itemTest, 0);
            put(itemTest2, 1);
        }};
        Hero myHero = new Hero(50, CharacterState.NORMAL,"Jean",10,0,0,itemPack);
        myHero.useItem(itemTest);
        myHero.useItem(itemTest2);
        assertEquals(0,myHero.getMyItem().get(itemTest));
        assertEquals(0,myHero.getMyItem().get(itemTest2));
    }

    @Test
    void StateEffectHeroAllState(){
        Hero myHero = new Hero(50, CharacterState.NORMAL,"Jean",10,0,0);
        myHero.stateEffect();
        assertEquals(52,myHero.getHp());
        myHero.setCurrentStatus(CharacterState.POISON);
        myHero.stateEffect();
        assertEquals(42,myHero.getHp());
        myHero.setCurrentStatus(CharacterState.SICK);
        myHero.stateEffect();
        assertEquals(37,myHero.getHp());
        assertEquals(5,myHero.getPower());
        myHero.setCurrentStatus(CharacterState.WEARY);
        myHero.stateEffect();
        assertEquals(2,myHero.getPower());
    }
}
