package chimera.epic_rpg_thing.model.AOE_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEDebuff extends AOEBaseSkill {
    Benefit debuff;
    AOEDebuff(int hpCost, int manaCost, Benefit debuff, ElementalEffect effect, int maxTargets, String description){
        setHpCost(hpCost);
        setManaCost(manaCost);
        this.debuff = debuff;
    }
    @Override
    public void effectTargets() {
        for(Creature c : getTargets()){
            c.effectBuff(debuff, false);
        }
    }

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
}
