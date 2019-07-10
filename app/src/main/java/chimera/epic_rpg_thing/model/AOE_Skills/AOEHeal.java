package chimera.epic_rpg_thing.model.AOE_Skills;

import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEHeal extends AOEBaseSkill {
    int healAmount;
    AOEHeal(int hpCost, int manaCost, int healAmount, ElementalEffect effect, int maxTargets, String description){
        this.setHpCost(hpCost);
        this.setManaCost(manaCost);
        this.healAmount = healAmount;
        this.setElementalEffect(effect);
        this.setMaxTargets(maxTargets);
        this.setDescription(description);
    }

    @Override
    public void effectTargets() {
        for(Creature c : this.getTargets()){
            c.effectHp(healAmount, getElementalEffect());
        }
    }
}