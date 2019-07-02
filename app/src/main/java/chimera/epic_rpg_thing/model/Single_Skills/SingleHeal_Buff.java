package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class SingleHeal_Buff extends SingleBaseSkill {
    int healAmount;
    Benefit buff;

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public Benefit getBuff() {
        return buff;
    }

    public void setBuff(Benefit buff) {
        this.buff = buff;
    }

    @Override
    public void effectTargets() {
        getTarget().effectBuff(buff, true);
        getTarget().effectHp(healAmount, getElementalEffect());
    }

    SingleHeal_Buff(int hpCost, int manaCost, int healAmount, Benefit buff, ElementalEffect effect, String description){
        setHpCost(hpCost);
        setManaCost(manaCost);
        setHealAmount(healAmount);
        setBuff(buff);
        setElementalEffect(effect);
        setDescription(description);
    }
}
