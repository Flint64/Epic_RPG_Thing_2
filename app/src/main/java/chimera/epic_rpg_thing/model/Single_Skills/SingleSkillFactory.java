package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class SingleSkillFactory {
    /**
     * Creates a new SingleSkill
     * @param type
     * @param hpCost
     * @param manaCost
     * @param effectAmount
     * @param benefit
     * @param effect
     * @param description
     * @return
     */
    public static SingleBaseSkill create(SingleType type, int hpCost, int manaCost, int effectAmount, Benefit benefit, ElementalEffect effect, String description){
        if(type == SingleType.DAMAGE){
            return new SingleDamage(hpCost, manaCost, effectAmount, effect, description);
        }else if(type == SingleType.BUFF){
            return new SingleHeal(hpCost, manaCost, effectAmount, effect, description);
        }else if(type == SingleType.DEBUFF){
            return new SingleDebuff(hpCost, manaCost, benefit, effect, description);
        }else if(type == SingleType.HEAL){
            return new SingleHeal(hpCost, manaCost, effectAmount, effect, description);
        }else if(type == SingleType.HEAL_BUFF){
            return new SingleHeal_Buff(hpCost, manaCost, effectAmount, benefit, effect, description);
        }else if(type == SingleType.DAMAGE_DEBUFF){
            return new SingleDamage_Debuff(hpCost, manaCost, effectAmount, benefit, effect, description);
        }
        return null;
    }
}
