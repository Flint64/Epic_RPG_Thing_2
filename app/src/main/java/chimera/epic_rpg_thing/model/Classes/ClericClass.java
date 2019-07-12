package chimera.epic_rpg_thing.model.Classes;

import java.util.ArrayList;

import chimera.epic_rpg_thing.model.AOE_Skills.AOEFactory;
import chimera.epic_rpg_thing.model.AOE_Skills.AOEType;
import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;
import chimera.epic_rpg_thing.model.ElementalType;
import chimera.epic_rpg_thing.model.Single_Skills.SingleSkillFactory;
import chimera.epic_rpg_thing.model.Single_Skills.SingleType;

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
        this.classSkills.put("DivineBandAid", AOEFactory.create(AOEType.AOE_HEAL, "Divine Band Aid",0, 10, 5, null, new ElementalEffect(ElementalType.DIVINE, 1), "You call upon your god to heal your targets", 3));
        this.classSkills.put("DivineHandShake", SingleSkillFactory.create(SingleType.HEAL, "Divine Hand Shake",0, 10, 10, null, new ElementalEffect(ElementalType.DIVINE, 1), "You lay hands on your target and heal there wounds"));
        this.classSkills.put("DivineWeapon", SingleSkillFactory.create(SingleType.DAMAGE_DEBUFF, "Divine Weapon",0, 5, 5, new Benefit(0, 0, 0, 0, 0, 0, 0, 5, 0, 3, false, false), new ElementalEffect(), "Your patron imbues your weapon with divine light and you bring it to bare against your enemies."));
        this.classSkills.put("DivineLight", SingleSkillFactory.create(SingleType.DAMAGE, "Divine Light",0,5, 5, new Benefit(), new ElementalEffect(ElementalType.DIVINE, 1), "A ray of divine light strikes down thy enemies"));
    }
}
