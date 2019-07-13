package chimera.epic_rpg_thing.model.AOE_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEBuff extends AOEBaseSkill {
    private final String CLASSNAME;
    Benefit benefit;
    public AOEBuff(){
        CLASSNAME = getClass().getName();
        setName("DEFAULT");
        setHpCost(0);
        setManaCost(0);
        setBenefit(new Benefit());
        setElementalEffect(new ElementalEffect());
        setMaxTargets(0);
        setDescription("DEFAULT");
    }
    public String getCLASSNAME(){
        return CLASSNAME;
    }
    public AOEBuff(String name, int hpCost, int manaCost, Benefit benefit, ElementalEffect effect, int maxTargets, String description){
        CLASSNAME = getClass().getName();
        setName(name);
        this.setHpCost(hpCost);
        this.setManaCost(manaCost);
        setBenefit(benefit);
        setElementalEffect(effect);
        setMaxTargets(maxTargets);
        setDescription(description);
    }
    @Override
    public void effectBuff() {
        for(Creature c : getTargets()){
            c.effectBuff(benefit);
        }
    }
    public void effectHP(){
        return;
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
