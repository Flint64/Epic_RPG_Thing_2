package chimera.epic_rpg_thing.model.AOE_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEDebuff extends AOEBaseSkill {
    private final String CLASSNAME;
    Benefit debuff;
    AOEDebuff(String name, int hpCost, int manaCost, Benefit debuff, ElementalEffect effect, int maxTargets, String description){
        CLASSNAME = getClass().getName();
        setName(name);
        setHpCost(hpCost);
        setManaCost(manaCost);
        this.debuff = debuff;
        setElementalEffect(effect);
        setMaxTargets(maxTargets);
        setDescription(description);
    }
    @Override
    public void effectBuff() {
        for(Creature c : getTargets()){
            c.effectBuff(debuff);
        }
    }
    public String getCLASSNAME(){
        return CLASSNAME;
    }
    public void effectHP(){
        return;
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
