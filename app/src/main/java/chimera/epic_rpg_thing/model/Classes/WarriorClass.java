package chimera.epic_rpg_thing.model.Classes;

import chimera.epic_rpg_thing.model.AOE_Skills.AOEDamage;
import chimera.epic_rpg_thing.model.AOE_Skills.AOEFactory;
import chimera.epic_rpg_thing.model.AOE_Skills.AOEType;
import chimera.epic_rpg_thing.model.ElementalEffect;
import chimera.epic_rpg_thing.model.ElementalType;

public class WarriorClass extends CharacterClass {
    public WarriorClass(){
        this.classLevel = 0;
        this.setName("Warrior");
        this.addClassMod("hpMulti", 10);
        this.addClassMod("manaMulti", 3);
        this.addWeaknesses(new ElementalEffect(ElementalType.POISON, 1));
        initializeSkills();
    }

    private void initializeSkills(){
        this.classSkills.put("BerserkerRage1", AOEFactory.create(AOEType.AOE_DEBUFF, 0,0,0, null, new ElementalEffect(ElementalType.PHYSICAL, 1), "With an insane roar the warrior terrifies there enemies.", 4));
    }
}
