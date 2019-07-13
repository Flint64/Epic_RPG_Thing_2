package chimera.epic_rpg_thing.model.AOE_Skills;

import chimera.epic_rpg_thing.model.Benefit;
import chimera.epic_rpg_thing.model.Creature;
import chimera.epic_rpg_thing.model.ElementalEffect;

public class AOEHeal_Buff extends AOEBaseSkill {
    private final String CLASSNAME;
    int healAmount;
    Benefit buff;

    /**
     * gets the amount healed
     * @return
     */
    public int getHealAmount() {
        return healAmount;
    }

    /**
     * sets the amount healed
     * @param healAmount
     */
    public void setHealAmount(int healAmount) {
        if(healAmount < 0) return;
        this.healAmount = healAmount;
    }

    /**
     * Gets the buff
     * @return
     */
    public Benefit getBuff() {
        return buff;
    }

    /**
     * Sets the buff
     * @param buff
     */
    public void setBuff(Benefit buff) {
        this.buff = buff;
    }

    /**
     * The AOE Heal and Buff class used for spells that will heal and buff the targets. (i.e. splash healing potion of toughness)
     * @param hpCost
     * @param manaCost
     * @param healAmount
     * @param buff
     * @param maxTargets
     * @param description
     */
    AOEHeal_Buff(String name, int hpCost, int manaCost, int healAmount, Benefit buff, ElementalEffect effect, int maxTargets, String description){
        CLASSNAME = getClass().getName();
        setName(name);
        setHpCost(hpCost);
        setManaCost(manaCost);
        setHealAmount(healAmount);
        setBuff(buff);
        setElementalEffect(effect);
        setMaxTargets(maxTargets);
        setDescription(description);
    }
    public String getCLASSNAME(){
        return CLASSNAME;
    }
    @Override
    public void effectHP() {
        for(Creature c : getTargets()){
            c.effectHp(healAmount, getElementalEffect(), false);
        }
    }
    @Override
    public void effectBuff(){
        for(Creature c : getTargets()){
            c.effectBuff(buff);
        }
    }
}
