package chimera.epic_rpg_thing.model.Classes;

import java.util.ArrayList;

import chimera.epic_rpg_thing.model.ElementalEffect;
import chimera.epic_rpg_thing.model.ElementalType;

public class ClericClass extends CharacterClass {
    public ClericClass(){
        this.classLevel = 0;
        this.setName("Cleric");
        this.addClassMod("hpMulti", 6);
        this.addClassMod("manaMulti", 5);
        this.setWeaknesses(new ArrayList<ElementalEffect>());
        this.addWeaknesses(new ElementalEffect(ElementalType.SHADOW, 1));
        initializeSkills();
    }
    private void initializeSkills(){

    }
}
