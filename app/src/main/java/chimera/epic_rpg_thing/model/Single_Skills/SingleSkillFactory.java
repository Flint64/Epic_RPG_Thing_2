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
            new SingleDamage(hpCost, manaCost, effectAmount, effect, description);
        }else if(type == SingleType.BUFF){
            new SingleHeal(hpCost, manaCost, effectAmount, effect, description);
        }else if(type == SingleType.DEBUFF){
            new SingleDebuff(hpCost, manaCost, benefit, effect, description);
        }else if(type == SingleType.HEAL){
            new SingleHeal(hpCost, manaCost, effectAmount, effect, description);
        }else if(type == SingleType.HEAL_BUFF){
            new SingleHeal_Buff(hpCost, manaCost, effectAmount, benefit, effect, description);
        }else if(type == SingleType.DAMAGE_DEBUFF){
            new SingleDamage_Debuff(hpCost, manaCost, effectAmount, benefit, effect, description);
        }
        return null;
    }
}
