package chimera.epic_rpg_thing;

import org.junit.Test;

import chimera.epic_rpg_thing.model.Character;

import static org.junit.Assert.assertEquals;

public class Character_Tests {
    @Test
    public void getMaxHP_valid(){
        Character character = new Character(100, 100, 10, null, (short)10, (short)2, (short)5, 8, 6, "Pedro");
        assertEquals(character.getMaxHP(), 180);
    }
}
