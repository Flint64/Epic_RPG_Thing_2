package chimera.epic_rpg_thing.model.AOE_Skills;

import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEDamage extends AOEBaseSkill {
    int damageAmount;
    AOEDamage(String name, int hpCost, int manaCost, int damageAmount, ElementalEffect effect, int maxTargets, String description){
        setName(name);
        this.setHpCost(hpCost);
        this.setManaCost(manaCost);
        this.damageAmount = damageAmount;
        this.setElementalEffect(effect);
        this.setMaxTargets(maxTargets);
        this.setDescription(description);
    }
    @Override
    public void effectHP() {
        for(Creature c : this.getTargets()){
            c.effectHp(-damageAmount, getElementalEffect(), false);
        }
    }
    public void effectBuff(){
        return;
    }
}
