package chimera.epic_rpg_thing.model.AOE_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEFactory {
    public static AOEBaseSkill create(AOEType type, int hpCost, int manaCost, int effectAmount, Benefit benefit, ElementalEffect effect, String description, int maxTargets){
        if(type == AOEType.AOE_DAMAGE){
            return new AOEDamage(hpCost, manaCost, effectAmount, effect, maxTargets, description);
        }else if(type == AOEType.AOE_HEAL){
            return new AOEHeal(hpCost, manaCost, effectAmount, effect, maxTargets, description);
        }else if(type == AOEType.AOE_BUFF){
            return new AOEBuff(hpCost, manaCost, benefit, effect, maxTargets, description);
        }else if(type == AOEType.AOE_DEBUFF){
            return new AOEDebuff(hpCost, manaCost, benefit, effect, maxTargets, description);
        }else if(type == AOEType.AOE_DAMAGE_DEBUFF){
            return new AOEDamage_Debuff(hpCost, manaCost, effectAmount, benefit, effect, maxTargets, description);
        }else if(type == AOEType.AOE_HEAL_BUFF){
            return new AOEHeal_Buff(hpCost, manaCost, effectAmount, benefit, effect, maxTargets, description);
        }
        return null;
    }
}
