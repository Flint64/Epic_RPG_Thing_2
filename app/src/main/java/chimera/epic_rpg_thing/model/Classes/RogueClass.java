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
        this.addWeaknesses(new ElementalEffect(ElementalType.FIRE, 1));
        initializeSkills();
    }


    /**
     * Initializes the skills of the Rogue Class
     */
    private void initializeSkills(){
        classSkills.put("StabbyStab", SingleSkillFactory.create(SingleType.DAMAGE, 0, 6, 10, new Benefit(), new ElementalEffect(ElementalType.PHYSICAL,  1), "Sneak strike - Stabby stab"));
        classSkills.put("DarkSlash", SingleSkillFactory.create(SingleType.DAMAGE_DEBUFF, 0, 3, 4, new Benefit(0,0,0,0,0, 0,0,0,10,2, false, false), new ElementalEffect(ElementalType.SHADOW, 1), "Shadow Strike - From the shadows the rogue strikes"));
        classSkills.put("RoguishStealth", SingleSkillFactory.create(SingleType.BUFF, 0, 5, 0, new Benefit(0,0,2, 0, 0, 0,10, 5, 10, 0, true, true), new ElementalEffect(ElementalType.SHADOW, 1), "Cloak of Shadows - The Rogue shrowds himself in shadow"));
        classSkills.put("PoisonVial", SingleSkillFactory.create(SingleType.DEBUFF, 0, 10, 0, new Benefit(0,0,0,0,0,10,0,0,0,3,false, false), new ElementalEffect(ElementalType.POISON, 1), "Poison Vial - The Rogue throws a poison vial at his enemies drowning them in misery"));
    }
}
