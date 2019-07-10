package chimera.epic_rpg_thing.model.Classes;

import chimera.epic_rpg_thing.model.AOE_Skills.AOEDamage;
import chimera.epic_rpg_thing.model.AOE_Skills.AOEFactory;
import chimera.epic_rpg_thing.model.AOE_Skills.AOEType;
import chimera.epic_rpg_thing.model.BaseSkill;
import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;
import chimera.epic_rpg_thing.model.ElementalType;
import chimera.epic_rpg_thing.model.Single_Skills.SingleSkillFactory;
import chimera.epic_rpg_thing.model.Single_Skills.SingleType;

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
        this.classSkills.put("BerserkerScream", AOEFactory.create(AOEType.AOE_DEBUFF, 0, 0, 0, new Benefit(), new ElementalEffect(ElementalType.PHYSICAL, 1), "Berserker Scream - With an insane roar the warrior terrifies there enemies.", 4));
        this.classSkills.put("PrecisionStabby", SingleSkillFactory.create(SingleType.DAMAGE, 0, 10, 15, new Benefit(), new ElementalEffect(ElementalType.PHYSICAL, 1), "Precision Strike - The warrior dodges nimbly forward before disemboweling the unfortunate enemy"));
        this.classSkills.put("ShieldBreaker", SingleSkillFactory.create(SingleType.DAMAGE_DEBUFF, 0, 15, 10, new Benefit(0,0,0,0,0,0,0,0,10,0,true, false), new ElementalEffect(ElementalType.PHYSICAL, 1), "Shield Breaker - The Warrior cleaves the enemies armor in twain"));
        this.classSkills.put("IntenseFocus", SingleSkillFactory.create(SingleType.BUFF, 0, 5, 0, new Benefit(0,0,0,0,0,0,0,10,0,0,true, true), new ElementalEffect(ElementalType.PHYSICAL, 1), "Battle Focus - The Warrior draws on his training to remove all distractions and focus on the fight."));
    }
}
