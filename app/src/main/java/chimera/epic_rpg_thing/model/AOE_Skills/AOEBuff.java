package chimera.epic_rpg_thing.model.AOE_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEBuff extends AOEBaseSkill {
    Benefit benefit;
    AOEBuff(int hpCost, int manaCost, Benefit benefit, ElementalEffect effect, int maxTargets, String description){
        this.setHpCost(hpCost);
        this.setManaCost(manaCost);
        setBenefit(benefit);
    }
    @Override
    public void effectTargets() {
        for(Creature c : getTargets()){
            c.effectBuff(benefit, true);
        }
    }

    /**
     * Gets the benefit of the skill
     * @return
     */
    public Benefit getBenefit(){
        return benefit;
    }

    /**
     * Sets the benefit of the skill
     * @param benefit
     */
    public void setBenefit(Benefit benefit){
        this.benefit = benefit;
    }
}
