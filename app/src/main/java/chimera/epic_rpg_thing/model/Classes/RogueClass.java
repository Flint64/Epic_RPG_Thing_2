package chimera.epic_rpg_thing.model.Classes;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;
import chimera.epic_rpg_thing.model.ElementalType;
import chimera.epic_rpg_thing.model.Single_Skills.SingleBuff;
import chimera.epic_rpg_thing.model.Single_Skills.SingleSkillFactory;
import chimera.epic_rpg_thing.model.Single_Skills.SingleType;

public class RogueClass extends CharacterClass {
    public RogueClass(){
        this.classLevel = 0;
        this.setName("Rogue");
        this.addClassMod("hpMulti", 4);
        this.addClassMod("manaMulti", 6);
        this.addWeaknesses(new ElementalEffect(ElementalType.FIRE, (short)1));
        initializeSkills();
    }

    /**
     * Initializes the skills of the Rogue Class
     */
    private void initializeSkills(){
        classSkills.put("StabbyStab1", SingleSkillFactory.create(SingleType.DAMAGE, 0, 6, 10, null, new ElementalEffect(ElementalType.PHYSICAL, (short) 1), "Stabby stab"));
        classSkills.put("DarkSlash1", SingleSkillFactory.create(SingleType.DAMAGE_DEBUFF, 0, 3, 4, new Benefit((short)0,(short)0,(short)0,0,0, 0,0,-2, new SingleBuff(),2, false), new ElementalEffect(ElementalType.SHADOW, (short)1), "From the shadows the rogue strikes"));
    }
}
