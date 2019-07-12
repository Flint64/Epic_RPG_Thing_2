package chimera.epic_rpg_thing.model.Classes;

import chimera.epic_rpg_thing.model.AOE_Skills.AOEFactory;
import chimera.epic_rpg_thing.model.AOE_Skills.AOEType;
import chimera.epic_rpg_thing.model.ElementalEffect;
import chimera.epic_rpg_thing.model.ElementalType;
import chimera.epic_rpg_thing.model.Single_Skills.SingleSkillFactory;
import chimera.epic_rpg_thing.model.Single_Skills.SingleType;
import chimera.epic_rpg_thing.model.Benefit;

public class MageClass extends CharacterClass {
    private ElementalEffect preferredElement = new ElementalEffect(ElementalType.FIRE, 1);
    public MageClass(){
        this.classLevel = 0;
        this.addClassMod("hpMulti", 2);
        this.addClassMod("manaMulti", 10);
        this.addWeaknesses(new ElementalEffect(ElementalType.PHYSICAL, 1));
        updateSkills();
    }
    public MageClass(ElementalEffect preferredElement){
        this.classLevel = 0;
        this.setName("Wizard");
        this.addClassMod("hpMulti", 2);
        this.addClassMod("manaMulti", 10);
        this.preferredElement = preferredElement;
        this.addWeaknesses(new ElementalEffect(ElementalType.PHYSICAL, 1));
        updateSkills();
    }

    public ElementalEffect getPreferredElement() {
        return preferredElement;
    }

    public void setPreferredElement(ElementalEffect preferredElement) {
        this.preferredElement = preferredElement;
    }

    /**
     * Initialize the skills fo the Mage Class.
     */
    public void updateSkills(){
        this.classSkills.put("Bolt", SingleSkillFactory.create(SingleType.DAMAGE, String.format("%s bolt", preferredElement.getNameOfType()),0, 5, 10, new Benefit(), preferredElement, String.format("%s bolt - A %s bolt streaks from the Mage, tearing their enemies asunder", preferredElement.getNameOfType(),preferredElement.getNameOfType())));
        this.classSkills.put("Orb", AOEFactory.create(AOEType.AOE_DAMAGE, String.format("%s orb", preferredElement.getNameOfType()),0, 15, 10, new Benefit(), preferredElement, String.format("%s orb - The mage lobs a %s orb at a group of enemies", preferredElement.getNameOfType(),preferredElement.getNameOfType()), 3));
        this.classSkills.put("Meditate", SingleSkillFactory.create(SingleType.BUFF, "Meditate",0, 0, 0, new Benefit(0,0,0,0,0,0,15,0,0,1,false, true), preferredElement, "Meditate - The Mage rests and draws in the latent mana from the battlefield"));
        this.classSkills.put("MagicBarrier", SingleSkillFactory.create(SingleType.BUFF, String.format("%s barrier"),0, 10, 0, new Benefit(0,0,0,0,0,0,0,0,15,2,false, true), preferredElement, String.format("%s barrier  - The Mage creates a %s wall in between him and his enemies", preferredElement.getNameOfType(),preferredElement.getNameOfType())));
    }
}
