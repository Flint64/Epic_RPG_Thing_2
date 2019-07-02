package chimera.epic_rpg_thing.model.Classes;

import chimera.epic_rpg_thing.model.ElementalEffect;
import chimera.epic_rpg_thing.model.ElementalType;

public class ClericClass extends CharacterClass {
    public ClericClass(){
        this.classLevel = 0;
        this.setName("Cleric");
        this.addClassMod("hpMulti", 6);
        this.addClassMod("manaMulti", 5);
        this.addWeaknesses(new ElementalEffect(ElementalType.SHADOW, (short)1));
        initializeSkills();
    }
    private void initializeSkills(){

    }
}
