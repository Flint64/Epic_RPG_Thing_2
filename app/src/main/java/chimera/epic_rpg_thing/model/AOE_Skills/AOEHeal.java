package chimera.epic_rpg_thing.model.AOE_Skills;

import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEHeal extends AOEBaseSkill {
    int healAmount;
    AOEHeal(String name, int hpCost, int manaCost, int healAmount, ElementalEffect effect, int maxTargets, String description){
        setName(name);
        this.setHpCost(hpCost);
        this.setManaCost(manaCost);
        this.healAmount = healAmount;
        this.setElementalEffect(effect);
        this.setMaxTargets(maxTargets);
        this.setDescription(description);
    }

    @Override
    public void effectHP() {
        for(Creature c : this.getTargets()){
            c.effectHp(healAmount, getElementalEffect(), false);
        }
    }
    @Override
    public void effectBuff(){
        return;
    }
}
