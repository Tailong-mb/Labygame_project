import labyGame.items.Item;
import labyGame.items.ItemName;
import labyGame.personnage.CharacterState;
import org.junit.jupiter.api.Test;
import labyGame.personnage.Hero;

import java.util.HashMap;

import static labyGame.sauvegarde.Save.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestSave {

    @Test
    void testSaveHeroAreEquals(){
        Item itemTest = new Item(2, ItemName.ANTIDOTE,"");
        Item itemTest2 = new Item(10, ItemName.HEALPOTION,"");
        HashMap<Item,Integer> itemPack = new HashMap<>() {{
            put(itemTest, 0);
            put(itemTest2, 1);
        }};
        Hero myHero = new Hero(50, CharacterState.NORMAL,"Jean",10,0,0,itemPack);
        saveHero(myHero);
        Hero secondHero = recuperationSaveHero();
        assertEquals(myHero, secondHero);
    }
}
