package chimera.epic_rpg_thing.model.Single_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class SingleDebuff extends SingleBaseSkill {
    Benefit debuff;

    /**
     * Gets the debuff
     * @return
     */
    public Benefit getDebuff() {
        return debuff;
    }

    /**
     * Sets the debuff
     * @param debuff
     */
    public void setDebuff(Benefit debuff) {
        this.debuff = debuff;
    }

    SingleDebuff(int hpCost, int manaCost, Benefit debuff, ElementalEffect effect, String description){
        setHpCost(hpCost);
        setManaCost(manaCost);
        setDebuff(debuff);
        setElementalEffect(effect);
        setDescription(description);
    }

    @Override
    public void effectTargets() {
        getTarget().effectBuff(debuff, false);
    }
}
