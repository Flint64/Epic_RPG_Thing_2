package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class SingleDamage_Debuff extends SingleBaseSkill {
    int damageAmount;
    Benefit debuff;

    public int getDamageAmount() {
        return damageAmount;
    }

    public void setDamageAmount(int damageAmount) {
        this.damageAmount = damageAmount;
    }

    public Benefit getDebuff() {
        return debuff;
    }

    public void setDebuff(Benefit debuff) {
        this.debuff = debuff;
    }

    SingleDamage_Debuff(int hpCost, int manaCost, int damageAmount, Benefit debuff, ElementalEffect effect, String description){
        setHpCost(hpCost);
        setManaCost(manaCost);
        setDamageAmount(damageAmount);
        setDebuff(debuff);
        setElementalEffect(effect);
        setDescription(description);
    }

    @Override
    public void effectTargets() {
        getTarget().effectBuff(debuff, false);
        getTarget().effectHp(-damageAmount, getElementalEffect());
    }
}
