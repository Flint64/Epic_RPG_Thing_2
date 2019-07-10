package chimera.epic_rpg_thing.model.AOE_Skills;

import android.util.Log;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEDamage_Debuff extends AOEBaseSkill {
    int damageAmount;
    Benefit debuff;

    /**
     * Gets the damage Amount
     * @return
     */
    public int getDamageAmount() {
        return damageAmount;
    }

    /**
     * Sets the damage amount won't allow for a negative damage amount
     * @param damageAmount
     */
    public void setDamageAmount(int damageAmount) {
        if(damageAmount < 0){
            Log.e("DamageAmount", "Tried to set the Damage Amount to negative");
            return;
        }
        this.damageAmount = damageAmount;
    }

    /**
     * gets the debuff
     * @return
     */
    public Benefit getDebuff() {
        return debuff;
    }

    /**
     * sets the debuff
     * @param debuff
     */
    public void setDebuff(Benefit debuff) {
        this.debuff = debuff;
    }

    AOEDamage_Debuff(int hpCost, int manaCost, int damageAmount, Benefit debuff, ElementalEffect effect, int maxTargets, String description){
        setHpCost(hpCost);
        setManaCost(manaCost);
        setDamageAmount(damageAmount);
        setDebuff(debuff);
        setElementalEffect(effect);
        setMaxTargets(maxTargets);
        setDescription(description);
    }
    @Override
    public void effectTargets() {
        for(Creature c : getTargets()){
            c.effectBuff(debuff);
            c.effectHp(-damageAmount, getElementalEffect(), false);
        }
    }
}
