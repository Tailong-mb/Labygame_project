import org.junit.jupiter.api.Test;
import labyGame.personnage.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestRole {


    // All test for Monster
    @Test
    void basicTalkMonster(){
        var myMonster = new Monster(50, CharacterState.NORMAL,"Demon",10,0,0);
        assertEquals("I will defeat you",myMonster.basicTalk("i WiLl DeFeat You"));
    }
}
