package chimera.epic_rpg_thing.model.AOE_Skills;

import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEHeal extends AOEBaseSkill {
    private final String CLASSNAME;
    int healAmount;
    AOEHeal(String name, int hpCost, int manaCost, int healAmount, ElementalEffect effect, int maxTargets, String description){
        CLASSNAME = getClass().getName();
        setName(name);
        this.setHpCost(hpCost);
        this.setManaCost(manaCost);
        this.healAmount = healAmount;
        this.setElementalEffect(effect);
        this.setMaxTargets(maxTargets);
        this.setDescription(description);
    }
    public String getCLASSNAME(){
        return CLASSNAME;
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
