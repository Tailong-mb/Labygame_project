import org.junit.jupiter.api.Test;
import labyGame.personnage.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestWizard {

    @Test
    void toStringWizard(){
        Wizard myWizard = new Wizard(50, CharacterState.NORMAL,"Alphonse",10,0,0);
        assertEquals("My name is Alphonse, I can help you if you answer correctly to my riddle or you can choose to fight against me.",myWizard.toString());
    }

    @Test
    void basicTalkWizard(){
        Wizard myWizard = new Wizard(50, CharacterState.NORMAL,"Alphonse",10,0,0);
        assertEquals("You'r ridiculous ahah !",myWizard.basicTalk("You'r ridiculous"));
    }

    @Test
    void secretAttackWizardBadStatus(){
        Wizard myWizard = new Wizard(50, CharacterState.WEARY,"Alphonse",10,0,0);
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        myWizard.secretAttack(myMonster);
        assertEquals(50,myMonster.getHp());
    }

    @Test
    void secretAttackWizardGoodStatusShouldKill(){
        Wizard myWizard = new Wizard(50, CharacterState.NORMAL,"Alphonse",10,0,0);
        Monster myMonster = new Monster(150, CharacterState.NORMAL,"Demon",10,0,0);
        myWizard.secretAttack(myMonster);
        assertTrue(myMonster.isDead());
    }

    @Test
    void basicAttackWizardShouldNotKIll(){
        Wizard myWizard = new Wizard(50, CharacterState.NORMAL,"Alphonse",10,0,0);
        Monster myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        myWizard.basicAttack(myMonster);
        assertFalse(myMonster.isDead());
    }

    @Test
    void basicAttackWizardShouldKIll(){
        Wizard myWizard = new Wizard(50, CharacterState.NORMAL,"Alphonse",30,0,0);
        Monster myMonster = new Monster(13, CharacterState.NORMAL,"Demon",10,0,0);
        myWizard.basicAttack(myMonster);
        assertTrue(myMonster.isDead());
    }

    @Test
    void ansVerificationWizardBadAnswer(){
        Wizard myWizard = new Wizard(50, CharacterState.NORMAL,"Alphonse",30,0,0);
        String riddleTest = myWizard.askQuestion();
        assertEquals(riddleTest,myWizard.getCurrentRiddle().getRid());
        //Not possible answer
        assertFalse(myWizard.ansVerification("Bonjour"));
        //Cut one letter in the answer
        assertFalse(myWizard.ansVerification(myWizard.getCurrentRiddle().getAns().substring(1)));
        //Add one letter in the answer
        assertFalse(myWizard.ansVerification(myWizard.getCurrentRiddle().getAns() + "a"));
    }

    @Test
    void ansVerificationWizardRightAnswer(){
        Wizard myWizard = new Wizard(50, CharacterState.NORMAL,"Alphonse",30,0,0);
        String riddleTest = myWizard.askQuestion();
        assertEquals(riddleTest,myWizard.getCurrentRiddle().getRid());
        //Exact Good answer
        assertTrue(myWizard.ansVerification(myWizard.getCurrentRiddle().getAns()));
        //add word in the answer
        assertTrue(myWizard.ansVerification("a " + myWizard.getCurrentRiddle().getAns()));
    }
}
